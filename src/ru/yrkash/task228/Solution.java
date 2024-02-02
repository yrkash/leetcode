package ru.yrkash.task228;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        if (nums.length == 1) {
            String str = String.valueOf(nums[0]);
            List<String> result = new ArrayList<>();
            result.add(str);
            return result;
        }
        List<Integer> buffList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            buffList.add(nums[i]);
            if (i < nums.length - 1 && (nums[i] + 1 == nums[i + 1])) continue;
            else {

                if (buffList.size() > 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(buffList.get(0));
                    stringBuilder.append("->");
                    stringBuilder.append(buffList.get(buffList.size() - 1));
                    result.add(stringBuilder.toString());
                } else {
                    result.add(buffList.get(0).toString());
                }
                buffList.clear();
            }
        }
        return result;
    }



        public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] ar = new int[] {0,1,2,4,5,7};
        int[] ar = new int[] {-1};
        List<String> result = solution.summaryRanges(ar);
        for (String str:result) {
            System.out.println(str);
        }
    }
}
