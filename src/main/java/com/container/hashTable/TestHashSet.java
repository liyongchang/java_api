package com.container.hashTable;

import java.util.HashSet;

public class TestHashSet {


    public static void main(String[] args) {
        HashSet set = new HashSet();
        Student student1 = new Student("1", "jack");
        Student student2 = new Student("1", "jack");
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student1.equals(student2));
        set.add(student1);
        set.add(student2);
        String s="123";
        System.out.println(set);
    }
}
