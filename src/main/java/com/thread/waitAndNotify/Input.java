package com.thread.waitAndNotify;

class Input implements Runnable {
    private Storage storage;
    private Storage2 storage2;
    private int num;

    public Input(Storage storage) {
        this.storage = storage;
    }

    public Input(Storage2 storage2) {
        this.storage2=storage2;
    }

    @Override
    public void run() {
        while (true) {
            storage.put(num++);
        }
    }
}