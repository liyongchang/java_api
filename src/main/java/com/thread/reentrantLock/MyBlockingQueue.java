package com.thread.reentrantLock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    int size;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition notFull = reentrantLock.newCondition();
    Condition notEmpty = reentrantLock.newCondition();

    LinkedList<E> linkedList = new LinkedList<>();

    public void enqueue(E e) throws InterruptedException {
        try {
            reentrantLock.lock();
            while (linkedList.size() == size) {
                notFull.await();
            }
            linkedList.add(e);
            System.out.println("入队：" + e);
            notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e;
        reentrantLock.lock();
        try {
            while (linkedList.size()==0){
                notEmpty.await();
            }
            e=linkedList.removeFirst();
            System.out.println("出队"+e);
            notFull.signal();
        }finally {
            reentrantLock.unlock();
        }
        return null;
    }

}
