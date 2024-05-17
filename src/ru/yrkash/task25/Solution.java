package ru.yrkash.task25;


public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        // A dummy node with 0 as value and pointing to the head of the list
        ListNode dummyNode = new ListNode(0, head);
        ListNode predecessor = dummyNode, current = dummyNode;

        // Iterate through the list
        while (current.next != null) {
            // Check if there are k nodes to reverse
            for (int i = 0; i < k && current != null; i++) {
                current = current.next;
            }
            // If less than k nodes remain, no more reversing is needed
            if (current == null) {
                return dummyNode.next;
            }

            // Temporarily store the next segment to be addressed after reversal
            ListNode temp = current.next;
            // Detach the k nodes from the rest of the list
            current.next = null;
            // 'start' will be the new tail after the reversal
            ListNode start = predecessor.next;
            // Reverse the k nodes
            predecessor.next = reverseList(start);
            // Connect the new tail to the temp segment stored before
            start.next = temp;
            // Move the predecessor and current pointers k nodes ahead
            predecessor = start;
            current = predecessor;
        }
        return dummyNode.next;
    }

    /**
     * Helper method to reverse the linked list.
     *
     * @param head The head of the list to be reversed.
     * @return The new head of the reversed list.
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }
        return prev;
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
        ListNode result = solution.reverseKGroup(node_1, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
