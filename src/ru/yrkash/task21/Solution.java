package ru.yrkash.task21;


public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list2 == null) return list1;
        if (list1 == null) return list2;
        ListNode result = new ListNode();
        ListNode curResult = result;

        while (list1 != null || list2 != null) {
            int firstArg = list1 == null ? Integer.MIN_VALUE : list1.val;
            int secondArg = list2 == null ? Integer.MIN_VALUE : list2.val;
            int curVal = 0;
            if ((firstArg == Integer.MIN_VALUE) || (firstArg > secondArg && secondArg != Integer.MIN_VALUE)) {
                curVal = secondArg;
                list2 = list2.next;
            }
            if ((secondArg == Integer.MIN_VALUE) || (firstArg <= secondArg && firstArg != Integer.MIN_VALUE)) {
                curVal = firstArg;
                list1 = list1.next;
            }
            // pointer for result remains
            curResult.next = new ListNode(curVal);
            // curResult move to new ListNode
            curResult = curResult.next;
        }
        return result.next;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node_1 = new ListNode(1);
        node_1.next = new ListNode(2);
        node_1.next.next = new ListNode(4);
        ListNode node_2 = new ListNode(1);
        node_2.next = new ListNode(3);
        node_2.next.next = new ListNode(4);
        ListNode result = solution.mergeTwoLists(node_1, node_2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
