package io.algoexpert.easy.arrays.nonconstructiblechange;

import java.util.Arrays;

public class NonConstructibleChange {

    /**
     * Time Complexity: NLog(N)
     * Space Complexity: O(1)
     * First, we are going to sort the array,
     * this will allow us to have ascending coins
     * We are going to use a total variable
     * where we are going to store the values of each coin while we traverse the array
     * If the value of the coin is higher than total + 1, the minimum change that we
     * cannot return is that value (total+1).
     * If the value is not higher than total + 1, then we will add the coin to the total variable
     *
     * @param coins
     * @return
     */
    public static int nonConstructibleChange(int[] coins) {
        // Write your code here.
        Arrays.sort(coins);
        int total = 0;
        for (int coin : coins) {
            if (coin > total + 1) {
                return total + 1;
            }
            total += coin;
        }
        return total + 1;
    }

    public static void main(String[] args) {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange(coins));
    }
}
