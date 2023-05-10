package com.thread.deadLock;

public class DeadLock1 {
    static String s1 = "123";
    static String s2 = "456";

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s1) {
                    System.out.println("1");
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (s2) {
                        System.out.println("2");
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    System.out.println("3");
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (s1) {
                        System.out.println("4");
                    }
                }
            }
        }).start();
    }
}
