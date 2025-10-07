package com.estudo.complexidade.tempo;

public class Logaritmica {
	
	//Logarítmica é a complexidade O(log n)
	public static int buscaBinaria(int[] arr, int x) {
		int l = 0, r = arr.length - 1;
		
		while (l <= r) {
			int m = (l + r) >>> 1; //O >>> significa que vai deslocar todos os bits uma posição para a direita. 
			if (arr[m] == x) return m;
			if (arr[m] < x) l = m + 1;
			else r = m - 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {2, 5, 8, 11, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
		System.out.println("Resultado: " + buscaBinaria(array, 8));
    }

}
