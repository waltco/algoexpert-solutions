package io.algoexpert.easy.arrays.twonumbersum;

import java.util.*;

public class TwoNumberSum {

    /**
     * Time Complexity: O(Nlog(N))
     * Space Complexity: O(1)
     * First, we are going to sort the array
     * We are going create two flags,
     * the left flag at the beginning of the array
     * the right flag at the end of the array
     * when the left flag increases, the sum increases
     * when the right flag decreases, the sum decreases
     * when the sum values of the left and right flag is equal to targetSum return the values
     * @param array
     * @param targetSum
     * @return
     */
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int currentSum = array[leftIndex] + array[rightIndex];
            if (currentSum == targetSum) {
                return new int[]{array[leftIndex], array[rightIndex]};
            } else if (currentSum > targetSum) {
                --rightIndex;
            } else {
                ++leftIndex;
            }
        }
        return new int[0];
    }
}
