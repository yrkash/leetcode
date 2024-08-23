package ru.yrkash.task637;


import java.util.*;

public class Solution {


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        double curSum = root.val;
        while (!deque.isEmpty()) {
            result.add(curSum / deque.size());
            curSum = 0.0;
            for (int i = deque.size(); i > 0; i--) {

                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                    curSum += node.left.val;
                }
                if (node.right != null) {
                    deque.offer(node.right);
                    curSum += node.right.val;
                }
            }

        }
        return result;
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
        String treeInitStr = "[1,2,3,4,5,6,7]";

        TreeNode treeNode = solution.initializeTree(treeInitStr);
        List<Double> result = solution.averageOfLevels(treeNode);
        System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println(result.get(2));

    }
}
