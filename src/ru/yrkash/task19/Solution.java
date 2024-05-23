package ru.yrkash.task19;


public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n == 0) return head; // Случай, когда n=0 (удаление последнего элемента)

        ListNode dummy = new ListNode(0, head);
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            if (fast.next == null) { // Проверка, находится ли узел на n-м расстоянии от конца
                if (i == n-1) return dummy.next.next; // Если да, удаляем первый элемент
                else return head; // Иначе возвращаем исходный список
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
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
        ListNode result = solution.removeNthFromEnd(node_1, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
