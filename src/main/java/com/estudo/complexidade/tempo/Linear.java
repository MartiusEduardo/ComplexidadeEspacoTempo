package com.estudo.complexidade.tempo;

public class Linear {
	
	//Complexidade de tempo O(n)
	public static int soma(int[] arr) {
		int soma = 0;
		for (int valor: arr) {
			soma += valor;
		}
		return soma;
	}
	
	public static void main(String[] args) {
		int[] array = {2, 5, 8, 11, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
		System.out.println("Resultado: " + soma(array));
    }

}
