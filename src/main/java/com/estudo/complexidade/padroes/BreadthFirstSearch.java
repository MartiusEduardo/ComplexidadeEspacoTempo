package com.estudo.complexidade.padroes;

import java.util.*;

public class BreadthFirstSearch {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // Adiciona uma aresta entre dois vértices (não direcionado)
    void addEdge(int v, int w) {
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
        graph.computeIfAbsent(w, k -> new ArrayList<>()).add(v);
    }

    // Implementação do BFS
    void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : graph.getOrDefault(vertex, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch g = new BreadthFirstSearch();

        // Criando o grafo:
        // 1 - 2
        // |   |
        // 4 - 3
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 3);

        System.out.println("BFS a partir do vértice 1:");
        g.bfs(1);  // Saída esperada: 1 2 4 3
    }
}

