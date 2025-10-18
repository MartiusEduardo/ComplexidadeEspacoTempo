package com.estudo.complexidade.padroes;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    /**
     * Encontra o próximo elemento maior para cada elemento em um array usando uma pilha monotônica.
     *
     * @param nums O array de entrada.
     * @return Um array onde cada elemento é o próximo maior elemento correspondente no array de entrada.
     * Retorna -1 se não houver um próximo elemento maior.
     */
    public static int[] nextGreaterElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n];
        // A pilha armazenará os números do array em ordem monotônicamente decrescente.
        Stack<Integer> stack = new Stack<>();

        // Iteramos da direita para a esquerda.
        for (int i = n - 1; i >= 0; i--) {
            int currentElement = nums[i];

            // 1. Manter a propriedade monotônica (decrescente)
            // Enquanto a pilha não estiver vazia e o topo for menor ou igual ao elemento atual,
            // remova o topo. Eles não podem ser o "próximo maior" para ninguém à esquerda.
            while (!stack.isEmpty() && stack.peek() <= currentElement) {
                stack.pop();
            }

            // 2. Definir o resultado
            // Se a pilha estiver vazia, não há elemento maior à direita.
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // O topo da pilha é o primeiro elemento maior à direita.
                result[i] = stack.peek();
            }

            // 3. Empurrar o elemento atual na pilha para as próximas iterações.
            stack.push(currentElement);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 4, 3};
        int[] result = nextGreaterElement(nums);

        System.out.println("Array Original: " + Arrays.toString(nums));
        // Saída Esperada: [5, 5, 6, -1, -1, -1] - É uma tradução do enum original
        System.out.println("Próximo Elemento Maior: " + Arrays.toString(result));

        System.out.println("--------------------");

        int[] nums2 = {8, 2, 5, 4, 3, 9, 1};
        int[] result2 = nextGreaterElement(nums2);

        System.out.println("Array Original: " + Arrays.toString(nums2));
        // Saída Esperada: [9, 5, 9, 9, 9, -1, -1]
        System.out.println("Próximo Elemento Maior: " + Arrays.toString(result2));
        
        System.out.println("--------------------");
        
        int[] nums3 = {8, 2, 15, 14, 12, 10, 5, 2, 1};
        int[] result3 = nextGreaterElement(nums3);

        System.out.println("Array Original: " + Arrays.toString(nums3));
        // Saída Esperada: [4, 5, 5, 3, 5, -1]
        System.out.println("Próximo Elemento Maior: " + Arrays.toString(result3));
    }
}