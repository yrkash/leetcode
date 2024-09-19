package ru.yrkash.task98;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Algo {
    private Integer previousValue; // variable to store the previously visited node's value

    /**
     * Validates if the given binary tree is a valid binary search tree (BST).
     *
     * @param root The root of the binary tree to check.
     * @return true if the given tree is a BST, false otherwise.
     */
    public boolean isValidBST(TreeNode root) {
        previousValue = null; // Initialize previousValue as null before starting traversal
        return inOrderTraversal(root);
    }

    /**
     * Performs an in-order depth-first traversal on the binary tree to validate BST property.
     * It ensures that every node's value is greater than the values of all nodes in its left subtree
     * and less than the values of all nodes in its right subtree.
     *
     * @param node The current node being visited in the traversal.
     * @return true if the subtree rooted at 'node' satisfies BST properties, false otherwise.
     */
    private boolean inOrderTraversal(TreeNode node) {
        if (node == null) {
            return true; // Base case: An empty tree is a valid BST.
        }
        // Traverse the left subtree. If it's not a valid BST, return false immediately.
        if (!inOrderTraversal(node.left)) {
            return false;
        }
        // Check the current node value with the previous node's value.
        // As it's an in-order traversal, previousValue should be less than the current node's value.
        if (previousValue != null && previousValue >= node.val) {
            return false; // The BST property is violated.
        }
        previousValue = node.val; // Update previousValue with the current node's value.
        // Traverse the right subtree. If it's not a valid BST, return false immediately.
        if (!inOrderTraversal(node.right)) {
            return false;
        }
        return true; // All checks passed, it's a valid BST.
    }

    public TreeNode initializeTree(String rootStr) {
        // Разбить строку на список узлов
        String[] nodes = rootStr.substring(1, rootStr.length() - 1).split(",");

        // Создать очередь для хранения узлов
        Queue<TreeNode> queue = new LinkedList<>();

        // Создать корневой узел
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        // Итерироваться по оставшимся узлам
        for (int i = 1; i < nodes.length; i++) {
            // Получить следующий узел из очереди
            TreeNode parent = queue.poll();

            // Проверить, является ли узел нулевым
            if (!nodes[i].equals("null")) {
                // Создать новый узел и добавить его в очередь
                TreeNode child = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = child;
                queue.offer(child);
            }

            // Повторить для правого дочернего узла
            i++;
            if (!nodes[i].equals("null")) {
                TreeNode child = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = child;
                queue.offer(child);
            }
        }

        // Вернуть корневой узел
        return root;
    }

    public static void main(String[] args) {
        Solution_Algo solution = new Solution_Algo();
        String treeInitStr = "[5,1,4,null,null,3,6]";

        TreeNode treeNode = solution.initializeTree(treeInitStr);
        System.out.println(solution.isValidBST(treeNode));

    }
}
