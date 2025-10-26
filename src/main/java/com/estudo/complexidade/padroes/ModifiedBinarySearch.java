package com.estudo.complexidade.padroes;

public class ModifiedBinarySearch {

    /**
     * Encontra o índice da primeira ocorrência de 'target' em um array ordenado.
     *
     * @param arr    O array ordenado (pode conter duplicatas).
     * @param target O elemento a ser encontrado.
     * @return O índice da primeira ocorrência do 'target', ou -1 se não for encontrado.
     */
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // Armazena o índice da "melhor" resposta encontrada até agora

        while (left <= right) {
            // Evita overflow de inteiros para (left + right) / 2
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // Esta é a "modificação" principal:
                // 1. Encontramos uma ocorrência do target.
                // 2. Armazenamos este índice como um *possível* resultado.
                result = mid;
                // 3. Como queremos a *primeira* ocorrência, continuamos
                //    procurando na metade esquerda do array.
                right = mid - 1;
                
            } else if (arr[mid] < target) {
                // O target está à direita
                left = mid + 1;
            } else {
                // arr[mid] > target
                // O target está à esquerda
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //         índices: 0  1  2  3  4  5  6  7  8  9
        int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};

        // Teste 1: Encontrar o 5
        int target1 = 5;
        int index1 = findFirstOccurrence(nums, target1);
        // A primeira ocorrência de 5 está no índice 1
        System.out.println("Primeira ocorrência de " + target1 + ": índice " + index1); // Saída: 1

        // Teste 2: Encontrar o 9
        int target2 = 9;
        int index2 = findFirstOccurrence(nums, target2);
        // A primeira ocorrência de 9 está no índice 7
        System.out.println("Primeira ocorrência de " + target2 + ": índice " + index2); // Saída: 7

        // Teste 3: Encontrar o 6
        int target3 = 6;
        int index3 = findFirstOccurrence(nums, target3);
        // A primeira ocorrência de 6 está no índice 4
        System.out.println("Primeira ocorrência de " + target3 + ": índice " + index3); // Saída: 4

        // Teste 4: Elemento inexistente
        int target4 = 7;
        int index4 = findFirstOccurrence(nums, target4);
        System.out.println("Primeira ocorrência de " + target4 + ": índice " + index4); // Saída: -1
    }
}
