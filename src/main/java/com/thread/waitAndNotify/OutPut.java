package com.thread.waitAndNotify;

class OutPut implements Runnable {
        private Storage storage;
        private int num;

        public OutPut(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            while (true) {
                storage.get();
            }
        }
    }