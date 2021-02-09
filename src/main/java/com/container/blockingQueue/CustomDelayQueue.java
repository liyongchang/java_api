package com.container.blockingQueue;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class CustomDelayQueue {

    public static void main(String[] args) throws InterruptedException {
        producer(); // 调用生产者
        consumer(); // 调用消费者
    }

    private static DelayQueue delayQueue = new DelayQueue();

    // 生产者
    public static void producer() {
        // 添加消息
        delayQueue.put(new MyDelay(1000, "消息1"));
        delayQueue.put(new MyDelay(3000, "消息2"));
    }

    // 消费者
    public static void consumer() throws InterruptedException {
        System.out.println("开始执行时间：" +
                DateFormat.getDateTimeInstance().format(new Date()));
        while (!delayQueue.isEmpty()) {
            System.out.println(delayQueue.take());
        }
        System.out.println("结束执行时间：" +
                DateFormat.getDateTimeInstance().format(new Date()));
    }


    static class MyDelay implements Delayed {

        // 延迟截止时间（单位：毫秒）
        private long delayTime = System.currentTimeMillis();

        // 借助 lombok 实现
        @Getter
        @Setter
        private String msg;

        public MyDelay(long delayTime, String msg) {
            this.delayTime = delayTime + this.delayTime;
            this.msg = msg;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return this.msg;
        }
    }


}
