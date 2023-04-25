package io.algoexpert.easy.arrays.sortedsquaredarray;

import java.util.Arrays;

public class SortedSquaredArray {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * This question becomes tricky because of negative numbers
     * since, this array is already sorted in ascending order we are going to use two flags
     * start and end across the array
     * We are going to create the output array which is going to handle the squared values
     * While we traverse the array, we are going to compare the absolute values of the start and end
     * if the end is higher we are going to square the value of endIndex, and decrease endIndex by 1
     * if the start is we are going to square the value of startIndex, and increase starIndex by 1
     * After that, we are going to decrease the value of the index for storing the next maximum square
     * @param array
     * @return
     */
    public static int[] sortedSquaredArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int outputIndex = array.length - 1;
        int[] output = new int[array.length];
        while (start <= end) {
            if (Math.abs(array[start]) < Math.abs(array[end])) {
                output[outputIndex] = array[end] * array[end];
                end--;
            } else {
                output[outputIndex] = array[start] * array[start];
                start++;
            }
            outputIndex--;
        }
        return output;
    }

    /**
     * Time Complexity: O(NLogN)
     * Space Complexity: O(N)
     * @param array
     * @return
     */
    public int[] sortedSquaredArrayS2(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] * array[i];
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-3, -2, -1};
        System.out.println(Arrays.toString(
                sortedSquaredArray(array)
        ));
    }
}
