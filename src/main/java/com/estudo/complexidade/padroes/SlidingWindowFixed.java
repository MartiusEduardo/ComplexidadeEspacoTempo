package com.estudo.complexidade.padroes;

public class SlidingWindowFixed {
    public static int maxSum(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = 0;

        // Soma inicial da primeira janela
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        // Move a janela
        for (int end = k; end < nums.length; end++) {
            windowSum += nums[end] - nums[end - k]; // entra e sai um elemento
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSum(nums, k)); // Saída: 9 (5 + 1 + 3)
    }
}
