package com.container.list;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        System.out.println(linkedList.size());

        Iterator iterator=linkedList.iterator();
        String first= (String) iterator.next();
        String second= (String) iterator.next();
        System.out.println(first);
        System.out.println(second);
        iterator.remove();
        System.out.println(linkedList.size());
        /*while (iterator.hasNext()){
            System.out.println(iterator);
        }*/
    }
}