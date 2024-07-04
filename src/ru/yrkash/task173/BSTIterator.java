package ru.yrkash.task173;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode resultNode = stack.pop();
        TreeNode node = resultNode.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return resultNode.val;
    }

    public boolean hasNext() {
        return !stack.empty();
    }
}
