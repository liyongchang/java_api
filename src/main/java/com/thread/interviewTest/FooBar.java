package com.thread.interviewTest;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    volatile boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!flag) {
                //  方法作用： 让当前线程从运行状态 转为 就绪状态，以允许具有相同优先级的其他线程获得运行机会。
                Thread.yield();
            }
            printFoo.run();
            flag = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag) {
                Thread.yield();
            }
            printBar.run();
            flag = true;
        }
    }
}