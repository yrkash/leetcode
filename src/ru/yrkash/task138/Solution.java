package ru.yrkash.task138;


import java.util.HashMap;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return head;

        HashMap<Node, Node> cloneMap = new HashMap<>();
        Node curNode = head;
        Node cloneNode = new Node(curNode.val);
        while (curNode != null) {
            cloneMap.put(curNode, cloneNode);
            curNode = curNode.next;
            if (curNode != null) {
                cloneNode.next = new Node(curNode.val);
                cloneNode = cloneNode.next;
            }
        }
        curNode = head;
        cloneNode = cloneMap.get(head);
        while (curNode != null) {
            cloneNode.random = cloneMap.get(curNode.random);
            curNode = curNode.next;
            cloneNode = cloneNode.next;
        }

        return cloneMap.get(head);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

//    [[1,null],[2,0],[3,null]]

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node_1 = new Node(1);
        node_1.next = new Node(2);
        node_1.next.next = new Node(3);
        node_1.random = null;
        node_1.next.random = node_1;
        node_1.next.next.random = null;

        Node result = solution.copyRandomList(node_1);
        printList(result);

    }
}
