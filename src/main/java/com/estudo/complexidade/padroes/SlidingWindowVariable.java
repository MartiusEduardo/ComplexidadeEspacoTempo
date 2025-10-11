package com.estudo.complexidade.padroes;

public class SlidingWindowVariable {
    public static int minSubArrayLen(int S, int[] nums) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];

            // Encolhe a janela enquanto a soma for >= S
            while (windowSum >= S) {
                minLength = Math.min(minLength, end - start + 1);
                windowSum -= nums[start];
                start++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 1, 5, 2, 3, 2};
    	int[] nums = {2, 1, 5, 2, 3, 2, 6, 12, 8, 5, 15, 90, 45, 32, 16, 1, 7, 9};
        int S = 140;
        System.out.println(minSubArrayLen(S, nums)); // Saída: 2 (5 + 2)
    }
}

