package ru.yrkash.task209;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class SolutionTest {

    @Test
    void minSubArrayLenTestOk() {
        int[] array = new int[] {1,2,3,4,5};
        int expected = 5;
        Solution solution = new Solution();
        int actual = solution.minSubArrayLen(15, array);
        Assert.assertEquals(expected, actual);
    }
    @Test
    void minSubArrayLenTestFailed() {
        int[] array = new int[] {1,2,3,4,5};
        int expected = 4;
        Solution solution = new Solution();
        int actual = solution.minSubArrayLen(15, array);
        Assert.assertNotEquals(expected, actual);
    }
}