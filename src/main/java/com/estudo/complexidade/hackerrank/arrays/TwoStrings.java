package com.estudo.complexidade.hackerrank.arrays;

import java.util.Arrays;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        byte[] bs1 = s1.getBytes();
        byte[] bs2 = s2.getBytes();

        Arrays.sort(bs2);

        for (byte b : bs1) {
            int bs = Arrays.binarySearch(bs2, b);
            if (bs >= 0) {
                return "Yes";
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }

}
