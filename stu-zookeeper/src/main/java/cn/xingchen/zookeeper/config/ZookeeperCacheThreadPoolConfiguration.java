/*
 * Copyright (c) 2019-2029, xingchen (cyhdreamer@163.com) All Rights Reserved.
 *
 */

package cn.xingchen.zookeeper.config;

import cn.xingchen.zookeeper.properties.EverestZookeeperCacheProperties;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chaiyunhao
 * @create 2019-10-14 14:59
 */
@Configuration
@EnableConfigurationProperties(EverestZookeeperCacheProperties.class)
@AutoConfigureAfter(EverestZookeeperAutoConfiguration.class)
public class ZookeeperCacheThreadPoolConfiguration {

    @Autowired
    private EverestZookeeperCacheProperties zookeeperCacheProperties;

    @Autowired
    private CuratorFramework curatorFramework;

    @Bean
    public PathChildrenCache createThreadPool(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("zookeeper-cache-pool-%d").build();

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(),
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());

        try {
            curatorFramework.create()
                    .creatingParentsIfNeeded()
                    .forPath(zookeeperCacheProperties.getBaseCachePath());

            /**
             * 监听子节点的变化情况
             */
            final PathChildrenCache childrenCache = new PathChildrenCache(curatorFramework, zookeeperCacheProperties.getBaseCachePath(), true);
            childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
            childrenCache.getListenable().addListener(
                    (client, event) -> {
                        switch (event.getType()) {
                            case CHILD_ADDED:
                                break;
                            case CHILD_REMOVED:
                                //TODO cyh
                                break;
                            case CHILD_UPDATED:
                                //TODO cyh
                                break;
                            default:
                                break;
                        }
                    },
                    threadPoolExecutor
            );

            return childrenCache;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private void doInvalidateCache(){

    }

}
