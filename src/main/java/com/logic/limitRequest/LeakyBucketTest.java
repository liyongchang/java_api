package com.logic.limitRequest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LeakyBucketTest {
    private static LeakyBucket leakyBucket = new LeakyBucket(1, 100);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(leakyBucket.tryAcquire());
                }
            });
        }
        executorService.shutdown();
    }
}
