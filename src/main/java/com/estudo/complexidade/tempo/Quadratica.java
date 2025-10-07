package com.estudo.complexidade.tempo;

public class Quadratica {

	//Complexidade de tempo O(n^2)
	public static int contaParesMenores(int[] arr) {
		int contar = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) contar++;
			}
		}
		return contar;
	}
	
	public static void main(String[] args) {
		int[] array = {2, 5, 8, 11, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
		System.out.println("Resultado: " + contaParesMenores(array));
    }
	
}
