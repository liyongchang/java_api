package com.thread.aqs;

public class MyCountDownLatch {

    private final int total;

    private int counter = 0;

    public MyCountDownLatch(int total) {
        this.total = total;
    }

    public void countDown() {
        synchronized (this) {
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            while (!(counter == total)) {
                this.wait();
            }
        }
    }
}
