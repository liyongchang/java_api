package com.thread.time;

import lombok.Data;

@Data
public abstract class MyTask implements Runnable {
    private Integer offset;
}
