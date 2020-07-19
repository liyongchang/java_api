package com.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore采用了CAS来实现，尽量避免锁的使用，提高了性能
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        //从信号量获取一个许可，如果无可用许可前将一直阻塞等待
                        semaphore.acquire();
                        System.out.println("线程:" + Thread.currentThread().getName() + "获得许可:" + index);
                        TimeUnit.SECONDS.sleep(1);
                        //释放一个许可，别忘了在finally中使用，注意：多次调用该方法，
                        // 会使信号量的许可数增加，达到动态扩展的效果，如：初始permits为1，
                        // 调用了两次release，最大许可会改变为2
                        semaphore.release();
                        System.out.println("允许TASK个数：" + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
