package ru.yrkash.task45;

public class Solution {

    public int jump(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;
        int[] value = new int[length];
        value[length - 1] = 0;
        int buff;
        int curValue = Integer.MAX_VALUE;
        for (int i = length - 2; i >= 0 ; i--) {
            if (nums[i] == 0) {
                value[i] = -1;
                continue;
            }
            buff = findMin(length -i -1, nums[i]);
//            System.out.println("buff [" + i + "] = " + buff);
            while (buff > 0) {
                if (value[i + buff] >= 0 && curValue > value[i + buff]) {
                    curValue = value[i + buff] + 1;
                }

                buff--;
            }
            value[i] = (curValue == Integer.MAX_VALUE) ? -1 : curValue;
            curValue = Integer.MAX_VALUE;
        }
        return value[0];
    }

    public static int findMin(int a, int b) {
        return a < b ? a : b;
    }

    //leetcode elegance solution
    public int jump_(int[] nums) {
        int ans = 0;
        int end = 0;
        int farthest = 0;

        // Implicit BFS
        for (int i = 0; i < nums.length - 1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                ++ans;
                break;
            }
            if (i == end) {   // Visited all the items on the current level
                ++ans;          // Increment the level
                end = farthest; // Make the queue size for the next level
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[]{4,1,2,3,1,0,4,4};
        System.out.println(solution.jump_(ar));
    }
}
