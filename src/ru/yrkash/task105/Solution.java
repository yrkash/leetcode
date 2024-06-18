package ru.yrkash.task105;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    // Map for finding index of current root in inorder array
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] valueArray;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length; // The number of nodes in the tree
        this.valueArray = preorder;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeRecurse(0, 0, n);
    }

    public TreeNode buildTreeRecurse(
            int preorderIndexStart,
            int inorderIndexStart,
            int size) {

        if(size <= 0) return null;
        //
        int curRootValue = valueArray[preorderIndexStart];
        int inorderRootIndex = inorderMap.get(curRootValue);

        int leftSubTreeSize = inorderRootIndex - inorderIndexStart;

        TreeNode leftSubTree = buildTreeRecurse(preorderIndexStart + 1, inorderIndexStart, leftSubTreeSize);
        TreeNode rightSubTree = buildTreeRecurse(preorderIndexStart + 1 + leftSubTreeSize, inorderRootIndex + 1, size - 1 - leftSubTreeSize);

        return new TreeNode(curRootValue, leftSubTree, rightSubTree);

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
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        String treeInitStr = "[1,2,3,4,5,null,6,7,null,null,null,null,8]";
        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);


    }
}
