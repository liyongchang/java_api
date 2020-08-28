package com.desing.chain;

import lombok.Data;

@Data
public abstract class Handler {
    protected String name;
    protected Handler nextHandler;

    public Handler(String name) {
        this.name = name;
    }

    public abstract boolean process(LeaveRequest leaveRequest);
}
