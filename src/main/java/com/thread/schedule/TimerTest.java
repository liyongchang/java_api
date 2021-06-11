package com.thread.schedule;

import qunar.tc.qmq.Message;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000, 2000);
        /*Producer producer
        Message message = producer.generateMessage("your subject");
        message.setProperty("key", "value");

//指定消息延时30分钟
        message.setDelayTime(30, TimeUnit.MINUTES);

//发送消息
        producer.sendMessage(message);*/
    }
}

class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("活动开始了");
    }
}
