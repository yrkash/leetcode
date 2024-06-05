package ru.yrkash.task146;

import java.util.HashMap;

//Definition for singly-linked list.
public class LRUCache {

    private final int capacity;
    private int size;

    private final DoublyLinkedNode head;
    private final DoublyLinkedNode tail;

    private final HashMap<Integer, DoublyLinkedNode> LRUMap;

    public HashMap<Integer, DoublyLinkedNode> getLRUMap() {
        return LRUMap;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.LRUMap = new HashMap<>();
        this.size = 0;
        head = new DoublyLinkedNode(0, 0);
        tail = new DoublyLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!LRUMap.containsKey(key)) return -1;
        DoublyLinkedNode node = LRUMap.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (LRUMap.containsKey(key)) {
            DoublyLinkedNode node = LRUMap.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
            LRUMap.put(key, newNode);
            addToHead( newNode);
            size++;
            if (size > capacity) {
                DoublyLinkedNode removeNode = removeTail();
                LRUMap.remove(removeNode.key);
                size--;
            }
        }
    }

    public void addToHead(DoublyLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DoublyLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DoublyLinkedNode removeTail() {
        DoublyLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(DoublyLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }



}
