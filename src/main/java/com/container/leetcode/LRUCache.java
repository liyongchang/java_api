package com.container.leetcode;

;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nmw on 2020/3/31.
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map = new LinkedHashMap(capacity);

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (null != map.get(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;

    }

    public void put(int key, int value) {
        if (null != map.get(key)) {
            map.remove(key);
        }
        if (map.size() == capacity) {
            map.remove(map.keySet().iterator().next());
        }

        map.put(key, value);
    }

    public static void main(String[] args) {
       /* String s = "{\"id\":178248,\"tradeNo\":\"20003003041\",\"voucherId\":\"GWY200330000001\",\"twoCode\":\"WgnS7LmkoO\",\"status\":\"N\"}";
        System.out.println(s);
        Map messageInfoMap = JSON.parseObject(s, HashMap.class);
        System.out.println(messageInfoMap.get("voucherId"));*/
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(1, 5);    // 该操作会使得密钥 2 作废
        cache.put(1, 2);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回  3
        System.out.println(cache.get(2));       // 返回  4

    }
}
