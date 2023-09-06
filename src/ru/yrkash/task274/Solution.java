package ru.mitryasov.task274;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            System.out.println(citations[i]);
        }
        if (citations[citations.length - 1] == 0 && citations[0] == 0) return 0;
        int range = 0;
        if (citations[citations.length - 1] > citations.length) range = citations.length;
        else {
            range = citations[citations.length - 1];
        }
        int result = range;
        System.out.println("Range = " + range);
        for (int i = 0; i < range; i++) {
            if (citations[citations.length - range + i] < range - i) result--;
            else break;
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[] {3, 0, 6, 5, 1};
        System.out.println(solution.hIndex(ar));

    }
}
