package com.container.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyLinkListTest {
    public static void main(String[] args) {

        System.out.println(8 % 11);
////
////        LinkedList<String> linkedList=new LinkedList();
////        linkedList.add("1");
////        linkedList.add("2");
////        linkedList.add("3");
////        System.out.println(linkedList.size());
////
////        Iterator iterator=linkedList.iterator();
////        String first= (String) iterator.next();
////        String second= (String) iterator.next();
////        System.out.println(first);
////        System.out.println(second);
////        iterator.remove();
////        System.out.println(linkedList.size());
//        while (iterator.hasNext()){
//            System.out.println(iterator);
//        }

        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        Set<String> strings = new HashSet<>();
        strings.add("122");
    }

}
