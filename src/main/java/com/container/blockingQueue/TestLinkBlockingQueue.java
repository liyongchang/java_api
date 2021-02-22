package com.container.blockingQueue;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.LinkedBlockingQueue;

public class TestLinkBlockingQueue {

    private static LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    linkedBlockingQueue.add(i);
                    System.out.println("producer add " + i);
                }
            }
        }).start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //定义循环的结束条件
                        boolean flag = true;
                        while (flag) {
                            Integer pool = linkedBlockingQueue.poll();
                            if (null == pool) {
                                flag = false;
                            }
                            System.out.println(Thread.currentThread().getName() + "consumer take " + pool);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

}
