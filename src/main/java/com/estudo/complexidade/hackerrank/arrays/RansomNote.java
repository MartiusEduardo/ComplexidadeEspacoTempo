package com.estudo.complexidade.hackerrank.arrays;

import java.util.List;
import java.util.stream.Collectors;

public class RansomNote {
    public static void main(String[] args) {
        checkMagazine(
                List.of("give", "me", "one", "grand", "today", "night"),
                List.of("give", "one", "grand", "today"));
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {
        List<String> smagazine = magazine.stream().sorted().collect(Collectors.toList());
        List<String> snote = note.stream().sorted().collect(Collectors.toList());

        int mc = 0;
        int nc = 0;

        while (mc < magazine.size() && nc < note.size()) {
            String word = smagazine.get(mc);
            String nword = snote.get(nc);
            if (word.equals(nword)) {
                nc++;
            }
            mc++;
        }

        if (nc == note.size()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
