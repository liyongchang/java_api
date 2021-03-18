package com.thread.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPool {
    private static int WORK_NUM = 5;
    private static int TASK_COUNT = 100;
    private final BlockingQueue<Runnable> taskQueue;
    // 工作线程组
    private WorkThread[] workThreads;

    public MyThreadPool() {
        this(WORK_NUM, TASK_COUNT);
    }

    public MyThreadPool(int work_num, int taskCount) {
        taskQueue = new LinkedBlockingDeque<>(taskCount);
        workThreads = new WorkThread[work_num];
        for (int i = 0; i < work_num; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].run();
        }

    }

    public void execute(Runnable task) {
        taskQueue.add(task);
    }

    private class WorkThread implements Runnable {
        @Override
        public void run() {
            Runnable runnable = null;
            while (true) {
                runnable = taskQueue.poll();
                if (runnable != null) {
                    runnable.run();
                }
                runnable = null;
            }
        }
    }
}
