package com.thread.timeWheel;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(1, TimeUnit.SECONDS, 60);
        System.out.println(Calendar.getInstance().getTime().toString() + "----创建一个时间刻度为60，每个刻度为1s的时间轮");
        hashedWheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println(Calendar.getInstance().getTime() + "----执行任务");
            }
        }, 80, TimeUnit.SECONDS);
    }
}
