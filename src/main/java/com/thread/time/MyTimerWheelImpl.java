package com.thread.time;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MyTimerWheelImpl implements MyTimerWheel {

    private final Map<Long, MyTask>[] wheel; // 轮子
    private final int wheelSize; // 轮子大小
    private final AtomicInteger currentOffset; // 当前偏移量
    private final AtomicLong nextId = new AtomicLong(1); // 任务编号;
    private final ExecutorService workers = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    /**
     * @param interval
     * @param wheelSize   轮子大小
     * @param firstOffset
     */
    @SuppressWarnings("all")
    public MyTimerWheelImpl(int interval, int wheelSize, int firstOffset) {
        this.wheelSize = wheelSize;
        this.wheel = new HashMap[wheelSize];
        currentOffset = new AtomicInteger(firstOffset);
        for (int i = 0; i < wheelSize; i++) {
            this.wheel[i] = new HashMap<Long, MyTask>();
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date().getTime());
                int offsetValue = currentOffset.getAndIncrement();
                int pointer = offsetValue % wheelSize; // 指针
                Map<Long, MyTask> slot = wheel[pointer];
                if (!slot.isEmpty()) {
                    slot.entrySet().removeIf(entry -> {
                        MyTask task = entry.getValue();
                        workers.submit(task);
                        return task.getOffset() == offsetValue;
                    });
                }
            }
        }, firstOffset, interval * 1000);
    }


    @Override
    public String addTask(MyTask task, Integer delayedTime) {
        long taskId = nextId.getAndIncrement();
        int offset = delayedTime + currentOffset.get();
        task.setOffset(offset);
        int slotIndex = offset % wheelSize;
        Map<Long, MyTask> slot = wheel[slotIndex];
        slot.put(taskId, task);
        return "task-" + Integer.toString(slotIndex, 32) + "-" + Long.toString(taskId, 32);
    }

    @Override
    public boolean removeTask(String taskId) {
        if (taskId != null && !taskId.trim().isEmpty()) {
            String[] arr = taskId.split("-");
            if (arr.length == 3) {
                int slotIndex = Integer.valueOf(arr[1], 32);
                Map<Long, MyTask> slot = wheel[slotIndex];
                if (!slot.isEmpty()) {
                    long key = Long.valueOf(arr[2], 32);
                    slot.remove(key);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String delayedTask(String taskId, Integer delayedTime) {
        if (taskId != null && !taskId.trim().isEmpty()) {
            String[] arr = taskId.split("-");
            if (arr.length == 3) {
                int slotIndex = Integer.valueOf(arr[1], 32);
                Map<Long, MyTask> slot = wheel[slotIndex];
                if (!slot.isEmpty()) {
                    long key = Long.valueOf(arr[2], 32);
                    MyTask task = slot.remove(key);
                    if (task != null) {
                        return addTask(task, delayedTime);
                    }
                }
            }
        }
        return null;
    }


}
