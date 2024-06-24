package ru.yrkash.task114;


import ru.yrkash.task117.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    // Map for finding index of current root in inorder array
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] valueArray;

    public void flatten(TreeNode root) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            // If the current node has a left child, we need to process it.
            if (currentNode.left != null) {
                // Find the rightmost node of the left subtree.
                TreeNode rightMostNode = currentNode.left;
                while (rightMostNode.right != null) {
                    rightMostNode = rightMostNode.right;
                }
                // Make the right of the rightmost node point to the root's right node.
                rightMostNode.right = currentNode.right;
                // Move the left subtree to the right.
                currentNode.right = currentNode.left;
                // After moving the left subtree, set the left child to null.
                currentNode.left = null;
            }
            // Move on to the right child of the current node.
            currentNode = currentNode.right;
        }
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
        String treeInitStr = "[1,2,5,3,4,null,6]";
        TreeNode treeNode = solution.initializeTree(treeInitStr);
        solution.flatten(treeNode);

        System.out.println(treeNode.val);
        System.out.println(treeNode.left);
        System.out.println(treeNode.right.val);
        System.out.println(treeNode.right.right.val);


    }
}
