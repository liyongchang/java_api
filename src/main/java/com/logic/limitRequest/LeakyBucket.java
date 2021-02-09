package com.logic.limitRequest;

import lombok.Data;

@Data
public class LeakyBucket {
    private double rate;
    private double burst;
    private long refreshTime;
    private int water;

    public LeakyBucket(double rate, double burst) {
        this.rate = rate;
        this.burst = burst;
    }

    private void refreshWater() {
        long now = System.currentTimeMillis();
        water = (int) Math.max(0, water - (now - refreshTime) * rate);
        refreshTime = now;
    }

    public synchronized boolean tryAcquire() {
        this.refreshWater();
        if (water < burst) {
            water++;
            return true;
        }
        return false;
    }
}