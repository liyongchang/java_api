package com.thread.waitAndNotify;

public class Storage2 {
    private int[] cells = new int[10];
    private int intPos, outPos;

    private int count;

    public synchronized void put(int num) {

        while (count == cells.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cells[intPos] = num;
        System.out.println("在cells放入数据" + intPos + "----" + cells[intPos]);
        intPos++;
        if (intPos == cells.length) {
            intPos = 0;
        }
        count++;
        this.notify();
    }

    public synchronized void get() {
        while (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int data = cells[outPos];
        System.out.println("取数据" + outPos + "----" + cells[outPos]);
        outPos++;
        if (outPos == cells.length) {
            outPos = 0;
        }
        count--;
        this.notify();
    }


    public static void main(String[] args) {
        Storage2 storage2 = new Storage2();
        Input2 input = new Input2(storage2);
        OutPut2 outPut = new OutPut2(storage2);
        new Thread(input).start();
        new Thread(outPut).start();
    }
}
