package com.thread.waitAndNotify;

public class Storage {
    private int[] cells = new int[10];
    private int intPos, outPos;

    private int count;

    public void put(int num) {
        cells[intPos] = num;
        System.out.println("在cells放入数据" + intPos + "----" + cells[intPos]);
        intPos++;
        if (intPos == cells.length) {
            intPos = 0;
        }
    }

    public void get() {
        int data = cells[outPos];
        System.out.println("取数据" + outPos + "----" + cells[outPos]);
        outPos++;
        if (outPos == cells.length) {
            outPos = 0;
        }
    }


    public static void main(String[] args) {
        Storage storage = new Storage();
        Input input = new Input(storage);
        OutPut outPut = new OutPut(storage);
        new Thread(input).start();
        new Thread(outPut).start();

    }
}
