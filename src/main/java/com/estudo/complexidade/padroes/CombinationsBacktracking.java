package com.estudo.complexidade.padroes;

import java.util.*;

public class CombinationsBacktracking {

    static void backtrack(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);              // escolhe
            backtrack(result, current, n, k, i + 1); // explora
            current.remove(current.size() - 1);      // desfaz a escolha (backtrack)
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> combinations = combine(4, 2);
        System.out.println("Combinações de 1..4 tomadas 2 a 2:");
        for (List<Integer> c : combinations) {
            System.out.println(c);
        }
    }
}

