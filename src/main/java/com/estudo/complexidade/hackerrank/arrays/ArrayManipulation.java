package com.estudo.complexidade.hackerrank.arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class ArrayManipulation {
	
	public static long arrayManipulation(int n, List<List<Integer>> queries) {
				
		long[] arr = new long[n + 2];
        
        for (List<Integer> query : queries) {
			int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);
            
            arr[a] += k;
            arr[b + 1] -= k;
        }
        
        long maximumValue = 0, currentValue = 0;
        
        for (int j = 1; j < n + 1; j++) {
			currentValue += arr[j];
			if (currentValue > maximumValue) {
				maximumValue = currentValue;
			}
		}
        
        return maximumValue;
		
    }

	public static void main(String[] args) throws IOException {
		
		//Resposta correta do exemplo 1: 10
		//Resposta correta do exemplo 2: 31
		//Resposta correta do exemplo 3: 6314
		//Resposta correta do exemplo 13: 2.490.686.975
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/estudo/complexidade/hackerrank/arrays/arquivos/exemploArrayManipulation1.txt"))) {
			String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			int n = Integer.parseInt(firstMultipleInput[0]);

			int m = Integer.parseInt(firstMultipleInput[1]);

			List<List<Integer>> queries = new ArrayList<>();

			IntStream.range(0, m).forEach(i -> {
			    try {
			        queries.add(
			            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			                .map(Integer::parseInt)
			                .collect(toList())
			        );
			    } catch (IOException ex) {
			        throw new RuntimeException(ex);
			    }
			});
			
			System.out.print(arrayManipulation(n, queries));
		} catch (NumberFormatException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
