package ru.yrkash.task133;


import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Node, Node> visited = new HashMap<>();

    //recursion
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        // выход из рекурсии, если Map уже содержит пару узла и его клона
        if (visited.containsKey(node)) return visited.get(node);

        Node cloneNode = new Node(node.val);

        visited.put(node, cloneNode);

        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        firstNode.neighbors.add(secondNode);
        firstNode.neighbors.add(thirdNode);
        secondNode.neighbors.add(firstNode);
        secondNode.neighbors.add(fourthNode);
        thirdNode.neighbors.add(firstNode);
        thirdNode.neighbors.add(fourthNode);
        fourthNode.neighbors.add(secondNode);
        fourthNode.neighbors.add(thirdNode);

        char[][] board  = {
        {'X','X','X','X','X'},
        {'X','X','O','O','O'},
        {'X','X','X','O','X'},
        {'O','O','O','X','X'}
        };

        Node cloneNode = solution.cloneGraph(firstNode);
        System.out.println(cloneNode.neighbors.get(1).val);
    }
}
