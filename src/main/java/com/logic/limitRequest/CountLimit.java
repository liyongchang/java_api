package com.logic.limitRequest;

public class CountLimit {
    private volatile long startTime;
    private volatile int count;
    private static final long MIN = 1000 * 60;
    private static final int LIMIT = 1000;

    private boolean apiCanExecute() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime >= MIN) {
            startTime = currentTime;
            count = 0;
        }
        if (count > LIMIT) {
            return false;
        }
        count++;
        return true;
    }
}
