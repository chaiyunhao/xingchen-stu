/*
 * Copyright (c) 2019-2029, xingchen (cyhdreamer@163.com) All Rights Reserved.
 *
 */

package cn.xingchen.zookeeper;

import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;

/**
 * @author chaiyunhao
 * @create 2019-10-13 17:52
 */
public class EverestCacheCuratorWatcher implements CuratorWatcher {
    @Override
    public void process(WatchedEvent watchedEvent) throws Exception {
        System.out.println("get data from watcher "+watchedEvent.getPath()+"  "+watchedEvent.getType());
    }
}
