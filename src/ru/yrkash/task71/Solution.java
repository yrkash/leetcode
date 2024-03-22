package ru.yrkash.task71;

import java.util.*;


public class Solution {

    public String simplifyPath(String path) {
        Set<String> operationSet = new HashSet<>(Arrays.asList("/", "."));
        Stack<String> stackPath = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                if (!stackPath.isEmpty()) {
                    stackPath.pop();
                }
            } else if (!operationSet.contains(component) && !component.isEmpty()) {
                stackPath.push(component);
            }
        }
        if (stackPath.isEmpty()) return "/";

        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stackPath) {
            simplifiedPath.append("/").append(dir);
        }

        return simplifiedPath.toString();
    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "/home//foo/";

        System.out.println(solution.simplifyPath(str));

    }
}
