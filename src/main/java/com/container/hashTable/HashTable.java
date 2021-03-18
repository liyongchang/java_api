package com.container.hashTable;

import lombok.Data;

public class HashTable<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final float default_load_factor = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];

    public void put(K k, V v) {
    }

    public void remove(K k) {
    }

    public V get(K k) {
        return null;
    }

    private void resize() {

    }

    private int hash(K k) {
        return 0;
    }

    @Data
    public static class Entry<K, V> {
        private K k;
        private V v;
        private Entry next;
    }


    public static void main(String[] args){
        String string="runoob";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("字符串反转前:"+string);
        System.out.println("字符串反转后:"+reverse);
    }


}
