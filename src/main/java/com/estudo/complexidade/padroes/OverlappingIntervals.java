package com.estudo.complexidade.padroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {

    /**
     * Funde todos os intervalos sobrepostos em um array de intervalos.
     *
     * @param intervals Um array 2D onde cada subarray é um intervalo [start, end].
     * @return Um novo array 2D com os intervalos sobrepostos já fundidos.
     */
    public static int[][] merge(int[][] intervals) {
        // 1. Lidar com casos base (array nulo, vazio ou com apenas um intervalo)
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 2. O passo crucial: ordenar os intervalos pelo valor de início (start)
        // Usamos um lambda para comparar o primeiro elemento de cada subarray.
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        // Alternativamente: Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        // Adiciona o primeiro intervalo para iniciar o processo
        mergedIntervals.add(intervals[0]);

        // 3. Iterar e fundir
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            // Pega o último intervalo da nossa lista de resultados para comparação
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            // Verifica se há sobreposição
            // O início do intervalo atual é menor ou igual ao fim do último intervalo fundido?
            if (currentInterval[0] <= lastMergedInterval[1]) {
                // Há sobreposição! Fundimos os intervalos.
                // O novo fim será o máximo entre os dois fins.
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                // Não há sobreposição. Adiciona o intervalo atual como um novo intervalo.
                mergedIntervals.add(currentInterval);
            }
        }

        // Converte a lista de volta para um array 2D para retornar
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Intervalos Originais: " + Arrays.deepToString(intervals));

        int[][] merged = merge(intervals);

        System.out.println("Intervalos Fundidos:  " + Arrays.deepToString(merged));
        // Saída Esperada: [[1, 6], [8, 10], [15, 18]]
        
        System.out.println("------------------------------------");

        int[][] intervals2 = {{1, 4}, {0, 2}, {3, 5}};
        System.out.println("Intervalos Originais: " + Arrays.deepToString(intervals2));
        // Primeiro, serão ordenados para: {{0, 2}, {1, 4}, {3, 5}}
        
        int[][] merged2 = merge(intervals2);
        
        System.out.println("Intervalos Fundidos:  " + Arrays.deepToString(merged2));
        // Saída Esperada: [[0, 5]]
    }
}