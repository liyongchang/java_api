package com.logic.limitRequest;

import lombok.Data;

@Data
public class Node {
    private long time;
    private long counter;
    private Node next;
    private int id;

    public Node(long time, long counter, int id) {
        this.time = time;
        this.counter = counter;
        this.id = id;
    }

    public void addCounter() {
        this.counter = this.counter + 1;
    }
}
