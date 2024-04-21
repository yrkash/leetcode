package ru.yrkash.task2;


public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overload = 0;
        ListNode result = new ListNode();
        ListNode curResult = result;

        while (l1 != null || l2 != null || overload > 0) {
            int firstArg = l1 == null ? 0 : l1.val;
            int secondArg = l2 == null ? 0 : l2.val;

            int sum = firstArg + secondArg + overload;
            overload = sum / 10;
            sum %= 10;

            curResult.next = new ListNode(sum);
            curResult = curResult.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node_1 = new ListNode(2);
        node_1.next = new ListNode(4);
        node_1.next.next = new ListNode(3);
        ListNode node_2 = new ListNode(5);
        node_2.next = new ListNode(6);
        node_2.next.next = new ListNode(4);
        ListNode result = solution.addTwoNumbers(node_1, node_2);
        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
