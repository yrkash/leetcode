package ru.yrkash.task117;


import ru.yrkash.task106.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {


    // Class-level variables to hold the previous node and
    // the next level's start node
    private Node previousNode;
    private Node nextLevelStartNode;

    public Node connect(Node root) {

        Node currentLevelNode = root;
        while (currentLevelNode != null) {
            previousNode = null;
            nextLevelStartNode = null;

            while (currentLevelNode != null) {
                modifyPointer(currentLevelNode.left);
                modifyPointer(currentLevelNode.right);
                // Move to the next node in the current level
                currentLevelNode = currentLevelNode.next;
            }
            currentLevelNode = nextLevelStartNode;
        }
        return root;
    }

    private void modifyPointer(Node currentNode) {

        if (currentNode == null) return;

        // If this is the first node of the next level,
        // update the nextLevelStart pointer
        if (nextLevelStartNode == null) nextLevelStartNode = currentNode;
        // If a previous node was found, link the previous node's next pointer
        // to the current node
        if (previousNode != null) previousNode.next = currentNode;
        // Update the previous pointer to the current node
        previousNode = currentNode;
    }

    public Node initializeTree(String rootStr) {
        // Разбить строку на список узлов
        String[] nodes = rootStr.substring(1, rootStr.length() - 1).split(",");

        // Создать очередь для хранения узлов
        Queue<Node> queue = new LinkedList<>();

        // Создать корневой узел
        Node root = new Node(Integer.parseInt(nodes[0]));
        queue.offer(root);
        // Итерироваться по оставшимся узлам
        for (int i = 1; i < nodes.length; i++) {
            // Получить следующий узел из очереди
            Node parent = queue.poll();

            // Проверить, является ли узел нулевым
            if (!nodes[i].equals("null")) {
                // Создать новый узел и добавить его в очередь
                Node child = new Node(Integer.parseInt(nodes[i]));
                parent.left = child;
                queue.offer(child);
            }

            // Повторить для правого дочернего узла
            i++;
            if (!nodes[i].equals("null")) {
                Node child = new Node(Integer.parseInt(nodes[i]));
                parent.right = child;
                queue.offer(child);
            }
        }

        // Вернуть корневой узел
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String treeInitStr = "[1,2,3,4,5,null,7]";
        Node root = solution.initializeTree(treeInitStr);

        Node connectRoot = solution.connect(root);
        System.out.println(connectRoot.next);
        System.out.println(connectRoot.left.next.val);
        System.out.println(connectRoot.left.right.next.val);


    }
}
