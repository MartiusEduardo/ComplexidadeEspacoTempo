package com.estudo.complexidade.padroes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {

    /**
     * Encontra os K maiores elementos em um array usando uma Min-Heap (PriorityQueue).
     *
     * @param nums O array de números de entrada.
     * @param k    O número de maiores elementos a serem encontrados.
     * @return Uma lista contendo os K maiores elementos.
     */
    public static List<Integer> findTopKLargest(int[] nums, int k) {
        // Validação de entrada
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            // Retorna uma lista vazia ou lança uma exceção, dependendo do requisito.
            return new ArrayList<>();
        }

        // PriorityQueue em Java é uma Min-Heap por padrão.
        // Ela manterá os K maiores elementos vistos até agora,
        // com o menor deles sempre no topo.
        //Para pegar os Top K Maiores
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
        	Integer peek = minHeap.peek();
            if (minHeap.size() < k) {
                // Se a heap ainda não está cheia, apenas adicione o elemento.
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                // Se o elemento atual for maior que o menor elemento na heap (o topo),
                // remova o menor e adicione o novo elemento.
                minHeap.poll(); // Remove o topo (menor elemento)
                minHeap.add(num); // Adiciona o novo elemento
            }
        }

        // Neste ponto, a heap contém os K maiores elementos do array.
        // A ordem na lista de retorno não é garantida, mas podemos ordená-la se necessário.
        List<Integer> topKList = new ArrayList<>(minHeap);
        Collections.sort(topKList, Collections.reverseOrder()); // Opcional: para ordenar o resultado
        return topKList;
    }
    
    public static List<Integer> findTopKSmallest(int[] nums, int k) {
        // Validação de entrada
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            // Retorna uma lista vazia ou lança uma exceção, dependendo do requisito.
            return new ArrayList<>();
        }
        
        //Para pegar os Top K Menores
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int num : nums) {
        	Integer peek = maxHeap.peek();
            if (maxHeap.size() < k) {
                // Se a heap ainda não está cheia, apenas adicione o elemento.
            	maxHeap.add(num);
            } else if (num < maxHeap.peek()) {
                // Se o elemento atual for maior que o menor elemento na heap (o topo),
                // remova o menor e adicione o novo elemento.
            	maxHeap.poll(); // Remove o topo (menor elemento)
            	maxHeap.add(num); // Adiciona o novo elemento
            }
        }

        // Neste ponto, a heap contém os K maiores elementos do array.
        // A ordem na lista de retorno não é garantida, mas podemos ordená-la se necessário.
        List<Integer> topKList = new ArrayList<>(maxHeap);
        Collections.sort(topKList); // Opcional: para ordenar o resultado
        return topKList;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 100, 1, 5, 8, 12, 6, 90, 50};
        int k = 4;

        List<Integer> topKElements = findTopKLargest(nums, k);

        System.out.println("Array Original: " + java.util.Arrays.toString(nums));
        System.out.println("Os " + k + " maiores elementos são: " + topKElements);
        // Saída esperada (ordenada): [100, 90, 50, 12]
        //------------------------------------------------------
        System.out.println("-----------------------------------------------");
        int[] nums2 = {3, 10, 100, 1, 5, 8, 12, 6, 90, 50};
        int k2 = 4;

        List<Integer> topKElements2 = findTopKSmallest(nums2, k2);

        System.out.println("Array Original: " + java.util.Arrays.toString(nums2));
        System.out.println("Os " + k + " menores elementos são: " + topKElements2);
        // Saída esperada (ordenada): [100, 90, 50, 12]
    }
}
