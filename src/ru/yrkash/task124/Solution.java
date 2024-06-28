package ru.yrkash.task124;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        depthFirstSearch(root);
        return maxSum;

    }


    public int depthFirstSearch(TreeNode node) {
        if (node == null) return 0;

        // Compute and get the maximum sum of paths from the left (right) child;
        // if the value is negative, we ignore the child's contribution by taking 0.
        int leftSubNodeSum = Math.max(depthFirstSearch(node.left), 0);
        int rightSubNodeSum = Math.max(depthFirstSearch(node.right), 0);
        // Update maxSum with the greater of the current maxSum or the sum of the current node value plus leftMaxSum and rightMaxSum.
        // This accounts for the scenario where the path involving the current node and its left and right children yields the max path sum.
        maxSum = Math.max(node.val + leftSubNodeSum + rightSubNodeSum, maxSum);
        // This call must return the maximum path sum including the currently evaluated node and one of its subtrees
        // since a path cannot have branches and must be straight through the parents or children nodes.
        return node.val + Math.max(leftSubNodeSum, rightSubNodeSum);
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
        String treeInitStr = "[-10,9,20,null,null,15,7]";

        TreeNode treeNode = solution.initializeTree(treeInitStr);

        System.out.println(solution.maxPathSum(treeNode));
        System.out.println(treeNode.left);
        System.out.println(treeNode.right.val);


    }
}
