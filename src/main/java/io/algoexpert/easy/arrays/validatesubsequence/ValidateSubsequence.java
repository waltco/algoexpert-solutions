package io.algoexpert.easy.arrays.validatesubsequence;

import java.util.List;

public class ValidateSubsequence {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * We are going to traverse the main array
     * If the element is equal to the value in the sequenceIndex, we are going to increase sequenceIndex
     * If sequenceIndex is equals to sequence size, return true, otherwise return false
     * @param array
     * @param sequence
     * @return
     */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int sequenceIndex = 0;
        for (Integer integer : array) {
            if (integer.equals(sequence.get(sequenceIndex))) {
                sequenceIndex++;
                if (sequenceIndex == sequence.size()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 5, 4, 7);
        List<Integer> sequence = List.of(1, 5, 7);
        System.out.println(isValidSubsequence(array, sequence));
    }

}
