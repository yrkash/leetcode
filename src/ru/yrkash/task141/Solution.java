package ru.yrkash.task141;


public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node_1 = new ListNode(3);
        ListNode node_2 = new ListNode(2);
        node_1.next = node_2;
        ListNode node_3 = new ListNode(0);
        node_2.next = node_3;
        ListNode node_4 = new ListNode(-4);
        node_3.next = node_4;
        node_4.next = node_2;
        System.out.println(solution.hasCycle(node_2));

    }
}
