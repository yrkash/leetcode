package ru.yrkash.task236;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        //if this node is p or q - return it
        if (root == p || root == q) return root;
        //recursion
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // If finding LCA in the left subtree returns null, the LCA is in the right subtree
        if (left == null) return right;
        if (right == null) return left;
        // If both left and right are non-null, we've found the LCA at the root
        return root;

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
        String treeInitStr = "[1,2,3,4,5,6,null]";

        TreeNode treeNode = solution.initializeTree(treeInitStr);
        TreeNode p = treeNode.left.left;
        TreeNode q = treeNode.left.right;
        TreeNode result = solution.lowestCommonAncestor(treeNode, p ,q);
        System.out.println(result.val);

    }
}
