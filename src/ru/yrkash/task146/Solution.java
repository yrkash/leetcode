package ru.yrkash.task146;


import java.util.HashMap;
import java.util.Map;

public class Solution {



    public static void main(String[] args) {
        Solution solution = new Solution();
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        HashMap<Integer, DoublyLinkedNode> cacheMap = obj.getLRUMap();
        for (Map.Entry<Integer, DoublyLinkedNode> pair : cacheMap.entrySet()) {
            System.out.println(pair.getValue().value);
        }
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

    }

}
