package cn.xingchen.base;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class MoreTread {

    ExecutorService threadPool = newFixedThreadPool(5);



}


class Task implements Runnable{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "执行任务");
    }
}