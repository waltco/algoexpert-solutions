package io.algoexpert.medium.arrays.threenumbersum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    /**
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     * First we are going to sort the array in order to have more control over the sum.
     * Then we are going to handle 3 flags:
     * currentNumber: Will act as the index to traverse, starts at 0
     * start: Will handle the number on the left, starts at currentNumber + 1. Traverse from left to right
     * end: The last index of the array that traverse from right to left.
     * If the sum of the values of currentNumber + start + end, then add this value to the array, start++, end--
     * if the sum of those values is lower than targetSum, increase the value of start
     * if the sum of those values is lower than targetSum, decrease the value of end
     * @param array
     * @param targetSum
     * @return
     */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        int currentNumber = 0;
        int end = array.length - 1;
        while (currentNumber + 1 < end) {
            int start = currentNumber + 1;
            end = array.length - 1;
            while (start < end) {
                int currentSum = array[currentNumber] + array[start] + array[end];
                if (currentSum == targetSum) {
                    result.add(new Integer[]{array[currentNumber], array[start], array[end]});
                    start++;
                    end--;
                } else if (currentSum < targetSum) {
                    start++;
                } else {
                    end--;
                }
            }
            currentNumber++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        System.out.println(threeNumberSum(array, targetSum));
    }
}
