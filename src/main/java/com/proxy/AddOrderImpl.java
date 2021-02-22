package com.proxy;

public class AddOrderImpl implements AddOrder {
    @Override
    public String addOrder() {
        System.out.println("下单");
        return "下单";
    }
}
