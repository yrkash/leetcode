package ru.yrkash.task61;


public class Solution {


    public ListNode rotateRight(ListNode head, int k) {
//        ListNode dummyNode = new ListNode(0, head);
        ListNode currentNode = head;
        if (head == null) return null;
        if (head.next == null) return head;
        int n = 1;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            n++;
        }
        currentNode.next = head;
        ListNode resultNode = head;
        ListNode precedingNode = resultNode;
        int shift = k % n;
        while (n - shift > 0) {
            precedingNode = resultNode;
            resultNode = resultNode.next;
            n--;
        }
        precedingNode.next = null;
        return resultNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        ListNode result = solution.rotateRight(node_1, 2);
        System.out.println(result.val);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
