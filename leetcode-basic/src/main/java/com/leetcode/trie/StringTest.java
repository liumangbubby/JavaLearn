package com.leetcode.trie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/4/3 12:48
 * @Modified
 */
public class StringTest {
    private static int count = 0;
    public static void main(String[] args) {
        int cpus = Runtime.getRuntime().availableProcessors();
        System.out.println("cpus : " + cpus);
        ExecutorService service = new ThreadPoolExecutor(cpus, cpus, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int f = 0; f < cpus; f++) {
            service.execute(() -> {
                for (int i = 0; i < 10000; i++) {
                    String lock = "sdfas".intern();
                    synchronized (lock) {
                        count = count + 1;
                    }
                    //System.out.println(Thread.currentThread().getName() + " " + count);
                }
            });
        }
        service.shutdown();
        while (!service.isTerminated()){
            System.gc();
        }
        System.out.println(count);
    }
}

