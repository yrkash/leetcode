package ru.yrkash.task86;


public class Solution {

    public ListNode partition(ListNode head, int x) {
        if ((head == null) || (head.next == null)) return head;

        ListNode head1 = new ListNode(0, head);
        ListNode head2 = new ListNode(0, head);
        ListNode tail1 = head1;
        ListNode tail2 = head2;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.val < x) {
                tail1.next = currentNode;
                tail1 = currentNode;
            } else {
                tail2.next = currentNode;
                tail2 = currentNode;
            }
            currentNode =  currentNode.next;
        }
        tail2.next = null;
        tail1.next = head2.next;

        return head1.next;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(1);
//        ListNode node_3 = new ListNode(2);
//        ListNode node_4 = new ListNode(4);
//        ListNode node_5 = new ListNode(5);
        node_1.next = node_2;
//        node_2.next = node_3;
//        node_3.next = node_4;
//        node_4.next = node_5;
        ListNode result = solution.partition(node_1, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
