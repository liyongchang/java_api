package com.desing.template;

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
}

