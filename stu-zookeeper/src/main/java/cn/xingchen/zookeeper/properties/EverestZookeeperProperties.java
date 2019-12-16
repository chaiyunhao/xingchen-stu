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
@ConfigurationProperties(prefix = "zookeeper")
public class EverestZookeeperProperties {
    /**
     * 连接地址
     */
    private String url;

    /**
     * 超时时间(毫秒)，默认1000
     */
    private int timeout = 1000;

    /**
     * 超时重试默认间隔时间(毫秒)
     */
    private int baseSleepTimeMs = 1000;

    /**
     * 重试次数，默认3
     */
    private int retry = 3;

    /**
     * 默认命名空间
     */
    private String nameSpace;
}
