package com.thread.threadPool;

import java.util.concurrent.*;

public class MonitorThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Thread.sleep(500L);// 方便测试

        ExecutorService executor = new MonitorThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

        for (int i = 0; i < 3; i++) {

            Runnable runnable = new Runnable() {

                public void run() {

                    try {

                        Thread.sleep(100L);

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }
                }

            };

            executor.execute(runnable);

        }

        executor.shutdown();

        System.out.println("Thread Main End!");

    }
}
