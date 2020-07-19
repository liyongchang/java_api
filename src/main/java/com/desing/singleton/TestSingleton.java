package com.desing.singleton;

public class TestSingleton {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton1.getInstance();
                }
            }).start();
        }
    }
}
