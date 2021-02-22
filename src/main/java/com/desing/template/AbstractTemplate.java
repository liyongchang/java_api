package com.desing.template;

import java.math.BigDecimal;

public abstract class AbstractTemplate {
    public void templateMethod() {
        checkNumber();
        queueUp();
        handleBusiness();
        serviceEvaluation();
    }

    private void serviceEvaluation() {
        System.out.println("服务评价");
    }

    protected abstract void handleBusiness();

    private void queueUp() {
        System.out.println("排队");
    }

    private void checkNumber() {
        System.out.println("取号");
    }

    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(100.00).compareTo(BigDecimal.valueOf(100.0)));
    }
}

