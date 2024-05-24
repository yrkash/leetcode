package ru.yrkash.task82;


public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);

        // This pointer will lag behind the current pointer and point to the last
        // node of the processed list without duplicates
        ListNode precedingNode = dummyNode;

        // This pointer will traverse the original list
        ListNode currentNode = head;

        // Iterate through the list
        while (currentNode != null) {
            // Skip all nodes that have the same value as the current node
            while (currentNode.next != null && currentNode.next.val == currentNode.val) {
                currentNode = currentNode.next;
            }

            // If there are no duplicates for the current value,
            // then the precedingNode should now point to the currentNode
            if (precedingNode.next == currentNode) {
                precedingNode = currentNode;
            } else {
                // Otherwise, bypass all duplicates by linking precedingNode to the node
                // following the last duplicate
                precedingNode.next = currentNode.next;
            }
            // Move to the next node in the list
            currentNode = currentNode.next;
        }

        // Return the processed list without duplicates
        return dummyNode.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(1);
        ListNode node_3 = new ListNode(1);
        ListNode node_4 = new ListNode(2);
        ListNode node_5 = new ListNode(2);
        ListNode node_6 = new ListNode(3);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_5.next = node_6;
        ListNode result = solution.deleteDuplicates(node_1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
