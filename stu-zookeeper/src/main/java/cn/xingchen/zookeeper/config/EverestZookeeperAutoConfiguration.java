/*
 * Copyright (c) 2019-2029, xingchen (cyhdreamer@163.com) All Rights Reserved.
 *
 */

package cn.xingchen.zookeeper.config;

import cn.xingchen.zookeeper.properties.EverestZookeeperProperties;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leaf
 */
@Configuration
@EnableConfigurationProperties(EverestZookeeperProperties.class)
public class EverestZookeeperAutoConfiguration {

    @Autowired
    private EverestZookeeperProperties zookeeperProperties;

    @Bean
    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(zookeeperProperties.getBaseSleepTimeMs(), zookeeperProperties.getRetry());
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(zookeeperProperties.getUrl())
                //session超时时间
                .sessionTimeoutMs(zookeeperProperties.getTimeout())
                //重试策略
                .retryPolicy(retryPolicy)
                .namespace(zookeeperProperties.getNameSpace())
                .build();
        client.start();

        return client;
    }
}
