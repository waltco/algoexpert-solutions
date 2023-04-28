package io.algoexpert.medium.arrays.firstduplicatevalue;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * The prompt explicitly says that the array contains integers
     * between 0<=x<=n where n = array.length
     * So we can take advantage of this.
     * We must traverse each element
     * look the abs(value) -1 and look for that index to check if it is negative
     * if it is negative we must return the abs(value)
     * if it is not negative, we must turn the the value in this index -> abs(value) -1 to negative
     * This way we make sure that when we find the first array[abs(value) -1] and this value
     * is negative, it means that this value is duplicated
     * @param array
     * @return
     */
    public static int firstDuplicateValue(int[] array) {
        for(int i=0;i<array.length;i++){
            if(array[Math.abs(array[i])-1]<0){
                return Math.abs(array[i]);
            }
            array[Math.abs(array[i])-1] *= -1;
        }
        return -1;
    }


    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * This solution is helped by the use of a hashset, since the lookup of an item
     * in this data structure is O(1) time, we can take advantage of that
     * So, the first thing to do is to traverse the array and check if the element
     * is inside the HashSet
     * if it is not in the HashSet we should add the element to the HashSet
     * if it is in the HashSet it means that the value is duplicated, so return it
     * @param array
     * @return
     */
    public int firstDuplicateValueS2(int[] array) {
        Set<Integer> values = new HashSet<>();
        for (int value : array) {
            if (values.contains(value)) {
                return value;
            }
            values.add(value);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 3, 3, 2, 4};
        System.out.println(firstDuplicateValue(array));
    }
}
