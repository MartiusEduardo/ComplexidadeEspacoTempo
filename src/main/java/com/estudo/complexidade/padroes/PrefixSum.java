package com.estudo.complexidade.padroes;

public class PrefixSum {
    private int[] prefix;

    // Construtor: pré-calcula as somas prefixadas
    public PrefixSum(int[] nums) {
        prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    // Retorna soma entre os índices i e j (inclusive)
    public int rangeSum(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 7, 8};
        PrefixSum ps = new PrefixSum(nums);

        System.out.println(ps.rangeSum(0, 2)); // 2 + 4 + 5 = 11
        System.out.println(ps.rangeSum(1, 4)); // 4 + 5 + 7 + 8 = 24
    }
}

