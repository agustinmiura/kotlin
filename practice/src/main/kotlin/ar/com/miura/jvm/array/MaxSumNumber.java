package ar.com.miura.jvm.array;


import java.util.PriorityQueue;

/**
 * https://leetcode.com/contest/weekly-contest-233/problems/maximum-ascending-subarray-sum/
 */
public class MaxSumNumber {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(12);
    }


    public int maxAscendingSum(int[] nums) {

        int position = 0;
        int max = nums.length;

        int currentSum = nums[0];
        int maxSum = currentSum;

        position++;
        while (position < max) {

            int currentNumber = nums[position];

            if (nums[position] > nums[position - 1]) {
                currentSum += nums[position];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }

            } else {
                currentSum = nums[position];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }

            }

            position++;

        }
        return maxSum;
    }
}