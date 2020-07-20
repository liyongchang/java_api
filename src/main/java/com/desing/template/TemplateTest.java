package com.desing.template;

public class TemplateTest {
    public static void main(String[] args) {
        AbstractTemplate saveMoney = new SaveMoney();
        saveMoney.templateMethod();
        AbstractTemplate takeMoney = new TakeMoney();
        takeMoney.templateMethod();
    }
}
