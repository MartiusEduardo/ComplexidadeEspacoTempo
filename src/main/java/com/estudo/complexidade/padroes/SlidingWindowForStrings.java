package com.estudo.complexidade.padroes;

import java.util.*;

public class SlidingWindowForStrings {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int start = 0, best = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (last.containsKey(c) && last.get(c) >= start) {
                start = last.get(c) + 1; // encolhe até remover o repetido
            }
            last.put(c, end);
            best = Math.max(best, end - start + 1);
        }
        return best;
    }
    
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] need = new int[256];
        for (char c : t.toCharArray()) need[c]++;

        int required = t.length();
        int start = 0, bestStart = 0, bestLen = Integer.MAX_VALUE;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (need[c] > 0) required--;
            need[c]--;

            while (required == 0) {
                if (end - start + 1 < bestLen) {
                    bestLen = end - start + 1;
                    bestStart = start;
                }
                char left = s.charAt(start++);
                need[left]++;
                if (need[left] > 0) required++; // perdeu algo essencial, precisa expandir
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
    	//LongestSubstringNoRepeat 
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3 ("abc")
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1 ("b")
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3 ("wke")
        
        //minWindow
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(minWindow("a", "aa"));  
    }
}
