package ru.yrkash.task6;


public class Solution {


    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        Character[][] zigzagStr = new Character[numRows][s.length()];
        int length = s.length();
        int counter = 0;
        int j = 0;
        while (counter < length) {
            for (int i = 0; i < numRows; i++) {
                if (counter >= length) break;
                zigzagStr[i][j] = s.charAt(counter);
                counter++;
            }
            for (int i = numRows - 2; i > 0; i--) {
                if (counter >= length) break;
                j++;
                zigzagStr[i][j] = s.charAt(counter);
                counter++;
            }
            j++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int k = 0; k < length; k++) {
                if (zigzagStr[i][k] != null) result.append(zigzagStr[i][k]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "PAYPALISHIRING";
        System.out.println(solution.convert(str, 4));
    }
}
