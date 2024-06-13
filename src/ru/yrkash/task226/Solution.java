package ru.yrkash.task226;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public TreeNode invertTree(TreeNode root) {

        invertTreeNoReturn(root);
        return root;
    }

    public void invertTreeNoReturn(TreeNode node) {
        if (node == null) return;
        TreeNode swap = node.left;
        node.left = node.right;
        node.right = swap;

        invertTreeNoReturn(node.left);
        invertTreeNoReturn(node.right);
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
        String treeInitStr = "[1,2,3]";
        TreeNode tree = solution.initializeTree(treeInitStr);
        TreeNode resultTree = solution.invertTree(tree);
        System.out.println(resultTree.val);


    }
}
