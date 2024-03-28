package ru.yrkash.task155;

import java.util.*;


public class Solution {

        public static void main(String[] args) {
            MinStack obj = new MinStack();
            obj.push(-2);
            obj.push(0);
            obj.push(-3);
            System.out.println(obj.getMin());
            obj.pop();
            System.out.println(obj.top());
            System.out.println(obj.getMin());

    }



}
