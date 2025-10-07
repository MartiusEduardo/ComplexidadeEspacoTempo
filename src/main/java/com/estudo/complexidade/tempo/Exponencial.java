package com.estudo.complexidade.tempo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exponencial {

	//Complexidade de tempo O(2^n)
	public static void subsets(int[] nums, int i, List<Integer> cur, List<List<Integer>> ans) {
		if (i == nums.length) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		subsets(nums, i + 1, cur, ans);
		cur.add(nums[i]);
		subsets(nums, i + 1, cur, ans);
		cur.remove(cur.size() - 1);
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> resultado = new ArrayList<>();
		subsets(nums, 0, new ArrayList<>(), resultado);
        List<List<Integer>> subsets = resultado;

        System.out.println("Subconjuntos possíveis de " + Arrays.toString(nums) + ":");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }

        System.out.println("\nTotal de subconjuntos: " + subsets.size());
    }
}
