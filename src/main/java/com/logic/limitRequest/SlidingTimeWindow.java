package com.logic.limitRequest;

import java.util.concurrent.TimeUnit;

public class SlidingTimeWindow {
    /**
     * 单位时间分割成多少块
     */
    private int slot;
    /**
     * 单位时间次数
     */
    private long limit;
    /**
     * 单位时间
     */
    private TimeUnit timeUnit;
    /**
     * 记录窗口滑动到的Node
     */
    private Node lastNode;
    /**
     * 每个slod 的时间段
     */
    private long slotTime;

    private void init() {
        Node currentNode = null;
        long current = System.currentTimeMillis();
        for (int i = 0; i < slot; i++) {
            if (lastNode == null) {
                lastNode = new Node(current, 0, i + 1);
                currentNode = lastNode;
            } else {
                lastNode.setNext(new Node(current, 0, i + 1));
                lastNode = lastNode.getNext();
            }
        }
        lastNode.setNext(currentNode);
        slotTime = (1000 * 60) / slot;
    }

    public synchronized boolean checkAndAdd() {
        reset();
        long sum=getSum();
        System.out.println(sum);
        if(sum>=limit){
            return false;
        }
        lastNode.addCounter();
        return true;
    }

    private void reset(int num, long currentTimeMillis) {
        if (num <= 0) {
            return;
        }
        Node currentNode = lastNode;
        for (int i = 0; i < num; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setTime(currentTimeMillis);
        currentNode.setCounter(0L);
        lastNode = currentNode;
    }

    private void reset() {
        long currentTimeMillis = System.currentTimeMillis();
        long time = lastNode.getTime();
        int count = (int) ((currentTimeMillis - time) / slotTime);
        if (count > slot) {
            count = slot;
        }
        reset(count, currentTimeMillis);
    }

    private long getSum() {
        long sum = 0L;
        Node currentNode = lastNode;
        for (int i = 0; i < slot; i++) {
            sum += currentNode.getCounter();
            currentNode = currentNode.getNext();
        }
        return sum;
    }

    public SlidingTimeWindow(int slot, long limit, TimeUnit timeUnit) {
        this.slot = slot;
        this.limit = limit;
        this.timeUnit = timeUnit;
        init();
    }
}
