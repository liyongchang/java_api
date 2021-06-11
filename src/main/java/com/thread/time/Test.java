package com.thread.time;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        MyTimerWheel iWheel = new MyTimerWheelImpl(1, 60, 5);
        String taskId = iWheel.addTask(new MyTask() {
            @Override
            public void run() {
                System.out.println("测试任务执行");
            }
        }, new Random().nextInt(10) + 10);
        System.out.println(taskId);
    }
}
