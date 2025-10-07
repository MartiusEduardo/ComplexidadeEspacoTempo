package com.estudo.complexidade.tempo;

public class Linearitmica {

	//Complexidade de tempo O(n log n) onde:
	//mergeSort = O(log n) e merge = O(n)
	//Dividir para conquistar
	public static void mergeSort(int[] arr, int left, int right) {
		if (left >= right) return;
		int middle = (left + right) >>> 1;
		mergeSort(arr, left, middle);
		mergeSort(arr, middle + 1, right);
		merge(arr, left, middle, right);
	}
	
	public static void merge(int[] arr, int left, int middle, int right) {
		int[] aux = new int[right - left + 1];
		int i = left, j = middle + 1, k = 0;
		while (i <= middle && j <= right) aux[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
		while (i <= middle) aux[k++] = arr[i++];
		while (j <= right) aux[k++] = arr[j++];
		System.arraycopy(aux, 0, arr, left, aux.length);
	}
	
	public static void main(String[] args) {
		int[] array = {38, 27, 43, 3, 9, 82, 10};
		mergeSort(array, 0, array.length - 1);
		for (int n : array) System.out.print(n + " ");
    }
	
}
