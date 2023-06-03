package com.thread.interviewTest;

class FooBar2 {
    private int n;

    public FooBar2(int n) {
        this.n = n;
    }

    private volatile boolean flag = true;
    private final Object object = new Object();

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (object) {
                while (flag) {
                    object.wait();
                }
                printFoo.run();
                flag = true;
                object.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (object) {
                while (!flag) {
                    object.wait();
                }
                printBar.run();
                flag = false;
                object.notifyAll();
            }
        }
    }
}