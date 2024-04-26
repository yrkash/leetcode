package ru.yrkash.task21;

public class Solution_GPT {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = list1 == null ? list2 : list1;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution_GPT solution = new Solution_GPT();
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
