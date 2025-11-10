package com.estudo.complexidade.padroes;

import java.util.Arrays;

public class TwoPointers {
	public static int[] encontrarParComSoma(int[] arr, int alvo) {
        // 1. Inicializa os ponteiros
        int inicio = 0;
        int fim = arr.length - 1;

        // 2. Loop enquanto os ponteiros não se cruzarem
        while (inicio < fim) {
            int soma = arr[inicio] + arr[fim];

            // 3. Compara a soma com o alvo
            if (soma == alvo) {
                // Encontramos o par!
                return new int[]{arr[inicio], arr[fim]};
            } else if (soma < alvo) {
                // Soma muito pequena, precisamos de um número maior
                inicio++;
            } else { // soma > alvo
                // Soma muito grande, precisamos de um número menor
                fim--;
            }
        }

        // Se o loop terminar, nenhum par foi encontrado
        return new int[]{}; // Retorna um array vazio
    }
	
	

    public static void main(String[] args) {
        int[] array = {2, 5, 8, 11, 14};
        int alvo = 13;

        int[] resultado = encontrarParComSoma(array, alvo);

        if (resultado.length > 0) {
            System.out.println("Par encontrado: " + Arrays.toString(resultado)); // Saída: Par encontrado: [2, 11]
        } else {
            System.out.println("Nenhum par encontrado.");
        }
    }
}
