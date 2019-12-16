/*
 * Copyright (c) 2019-2029, xingchen (cyhdreamer@163.com) All Rights Reserved.
 *
 */

package cn.xingchen.zookeeper.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chaiyunhao
 * @create 2019-10-13 17:31
 */
@Data
@ConfigurationProperties(prefix = "zookeeper.cache")
public class EverestZookeeperCacheProperties {

    private String baseCachePath = "/everest/cache";

}
