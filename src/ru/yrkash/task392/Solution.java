package ru.yrkash.task392;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int lengthSub = s.length();
        int indexSub = 0;

        for (int i = 0; i < t.length(); i++) {
            char curChar = s.charAt(indexSub);
            int index = t.indexOf(curChar, i);
            if (index != -1 ) {
                indexSub++;
                i = index;
            }
        }
//        System.out.println(indexSub + " " + lengthSub);
        return (indexSub == lengthSub) ? true : false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
    }
}
