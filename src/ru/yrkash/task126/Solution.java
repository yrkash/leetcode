package ru.yrkash.task126;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int sumNumbers(TreeNode root) {
        return depthFirstSearch(root, 0);
    }

    public int depthFirstSearch(TreeNode node, int sum) {
        if (node == null) return 0;

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            System.out.println(sum);
            return sum;
        }

        return depthFirstSearch(node.left, sum) + depthFirstSearch(node.right, sum);
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
        String treeInitStr = "[4,9,0,5,1]";

        TreeNode treeNode = solution.initializeTree(treeInitStr);

        System.out.println(solution.sumNumbers(treeNode));
        System.out.println(treeNode.left);
        System.out.println(treeNode.right.val);


    }
}
