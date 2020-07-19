package com.thread.waitAndNotify;

class OutPut2 implements Runnable {
    private Storage2 storage;
    private int num;

    public OutPut2(Storage2 storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            storage.get();
        }
    }
}