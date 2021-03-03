package com.desing.template;

import java.util.HashMap;

public class TemplateTest {
    public static void main(String[] args) {
        HashMap map = new HashMap(1000);
        map.put("", "");

        AbstractTemplate saveMoney = new SaveMoney();
        saveMoney.templateMethod();
        AbstractTemplate takeMoney = new TakeMoney();
        takeMoney.templateMethod();
    }
}
