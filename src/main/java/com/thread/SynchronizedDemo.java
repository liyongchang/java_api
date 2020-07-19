package com.thread;

public class SynchronizedDemo {

    private void method (){
        synchronized (this) {
            System.out.println("method 1 start!!!!");
        }
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}