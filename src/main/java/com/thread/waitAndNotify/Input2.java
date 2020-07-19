package com.thread.waitAndNotify;

class Input2 implements Runnable {
    private Storage2 storage2;
    private int num;

    public Input2(Storage2 storage2) {
        this.storage2 = storage2;
    }

    @Override
    public void run() {
        while (true) {
            storage2.put(num++);
        }
    }
}