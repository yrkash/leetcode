package ru.yrkash.task155;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stk1;
    private Stack<Node> stk2;

    public MinStack() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    public void push(int val) {
        stk1.push(val);
        int curMin;
        if (stk2.empty()) curMin = val;
        else {
            curMin = stk2.peek().getMin();
        }
        if (val < curMin) curMin = val;
        Node newNode = new Node(val, curMin);
        stk2.push(newNode);
    }

    public void pop() {
        stk2.pop();
        stk1.pop();
    }

    public int top() {
        return stk1.peek();
    }

    public int getMin() {
        return stk2.peek().getMin();
    }

    class Node {
        private int value;
        private int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }
}

