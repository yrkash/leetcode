package ru.mitryasov.task55;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int curRootIndex = nums.length - 1;
        int curRoot = nums [curRootIndex];
        if (curRoot == 0 && curRootIndex == 0) return false;
        int buff;
        int buffIndex;
        for (int i = nums.length - 1; i > 0; i--) {
            buffIndex = i - 1;
            buff = nums [buffIndex];
            if (buff + buffIndex >= curRootIndex) curRootIndex = buffIndex;
        }
        if (curRootIndex != 0) return false;
        return true;
    }

    public int[] jump(int[] nums) {
        int [] jumpArray = new int[nums.length];
        jumpArray[nums.length - 1] = 0;
        for (int i = nums.length - 2;  i >= 0; i--) {
            int buff = nums.length - i - nums[i];
            if (buff <= 1) jumpArray[i] = 1;
            else {
                jumpArray[i] = buff;
            }
        }
        return jumpArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[] {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(ar));
        int[] arJump = solution.jump(ar);
        for (int i = 0; i < arJump.length; i++) {
            System.out.println(arJump[i]);
        }
    }
}
