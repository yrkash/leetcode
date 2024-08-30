package ru.yrkash.task530;



import java.util.*;

public class Solution {

    private int previousValue;
    private int minDifference;
    private static final int INFINITY = Integer.MAX_VALUE;


    public int getMinimumDifference(TreeNode root) {

        previousValue = INFINITY;
        minDifference = INFINITY;
        inOrderTraversal(root);
        return minDifference;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return; // Base case: if node is null, return to stop the traversal
        }
        inOrderTraversal(node.left); // Visit left subtree

        // Compute the minimum difference with the previous value (if not first node)
        if (previousValue != INFINITY) {
            minDifference = Math.min(minDifference, Math.abs(node.val - previousValue));
        }
        previousValue = node.val; // Update the previous value to the current node's value

        inOrderTraversal(node.right); // Visit right subtree
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
        Solution solution = new Solution();
        String treeInitStr = "[1,20,30,40,50,32,31]";

        TreeNode treeNode = solution.initializeTree(treeInitStr);
        int result = solution.getMinimumDifference(treeNode);
        System.out.println(result);

    }
}
