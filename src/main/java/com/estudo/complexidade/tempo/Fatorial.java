package com.estudo.complexidade.tempo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fatorial {

	//Complexidade de tempo O(n!)
	public static void permuta(int[] arr, int left, int right, List<int[]> out) {
		if (left == right) {
			out.add(arr.clone());
			return;
		}
		
		for (int i = left; i <= right; i++) {
			swap(arr, left, i);
			permuta(arr, left + 1, right, out);
			swap(arr, left, i);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temporary = arr[i];
		arr[i] = arr[j];
		arr[j] = temporary;
	}
	
	public static void main(String[] args) {
		int[] numeros = {1, 2, 3};
        List<int[]> resultado = new ArrayList<>();

        permuta(numeros, 0, numeros.length - 1, resultado);

        System.out.println("Permutações possíveis de " + Arrays.toString(numeros) + ":");
        for (int[] p : resultado) {
            System.out.println(Arrays.toString(p));
        }

        System.out.println("\nTotal de permutações: " + resultado.size());
    }
	
}
