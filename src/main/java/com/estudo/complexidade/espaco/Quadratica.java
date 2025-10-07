package com.estudo.complexidade.espaco;

public class Quadratica {

	public static int[][] multEscalar(int n, int k) {
		int[][] matriz = new int[n][n]; //O(n^2) espaço
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = (i + j) * k;
			}
		}
		return matriz;
	}
	
	public static void main(String[] args) {
		int n = 4;
        int k = 3;

        int[][] resultado = multEscalar(n, k);

        System.out.println("Matriz resultante (" + n + "x" + n + "):");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + "\t");
            }
            System.out.println();
        }
    }
	
}
