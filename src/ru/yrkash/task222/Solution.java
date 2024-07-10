package ru.yrkash.task222;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

   public int countNodes(TreeNode root) {

        if (root == null) return 0;

        int leftSubTreeDepth = findDepth(root.left);
        int rightSubTreeDepth = findDepth(root.right);
        // if depths equals then left tree - full
        if (leftSubTreeDepth == rightSubTreeDepth) {
            // 1 << depth  - bit manipulation. Find count of nodes in full subtree with local root. (2 ^ depth)

            return (1 << leftSubTreeDepth) + countNodes(root.right);
        } else {
            return (1 << rightSubTreeDepth) + countNodes(root.left);
        }
    }

    private int findDepth(TreeNode node) {
        int depth = 0;

        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
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

        System.out.println(solution.countNodes(treeNode));
        System.out.println(treeNode.left);
        System.out.println(treeNode.right.val);


    }
}
