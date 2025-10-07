package com.estudo.complexidade.espaco;

public class Linear {

	public static int[] copia(int[] arr) {
		int[] b = new int[arr.length]; //Complexidade de espaço O(n)
		for (int i = 0; i < arr.length; i++) b[i] = arr[i];
		return b;
	}
	
	public static void main(String[] args) {
		int[] array = {2, 5, 8, 11, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
		int[] novoArray = copia(array);
		for (int n : novoArray) System.out.print(n + " ");
    }
	
}
