package com.logic.limitRequest;

import lombok.Data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class TokenLimiter {
    private ArrayBlockingQueue<String> blockingQueue;
    private int limit;
    private TimeUnit timeUnit;
    private int period;

    public TokenLimiter(int limit, TimeUnit timeUnit, int period) {
        this.blockingQueue = new ArrayBlockingQueue<>(limit);
        this.limit = limit;
        this.timeUnit = timeUnit;
        this.period = period;
        init();
        start();
    }

    private void init() {
        for (int i = 0; i < limit; i++) {
            blockingQueue.add("1");
        }
    }

    private void addToken() {
        blockingQueue.offer("1");
    }

    public boolean tryAcquire() {
        return blockingQueue.poll() == null ? false : true;
    }

    private void start() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        addToken();
                    }
                }, 10, period, timeUnit);
    }


}
