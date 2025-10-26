package com.estudo.complexidade.padroes;

import java.util.*;

//DFS = DepthFirstSearch
public class DepthFirstSearch {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // Adiciona uma aresta entre dois vértices (não direcionado)
    void addEdge(int v, int w) {
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
        graph.computeIfAbsent(w, k -> new ArrayList<>()).add(v);
    }

    // Função auxiliar recursiva do DFS
    void dfsUtil(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");

        // Visita todos os vértices adjacentes ainda não visitados
        for (int neighbor : graph.getOrDefault(v, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // Função principal do DFS
    void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch();

        // Criando o grafo:
        // 1 - 2
        // |   |
        // 4 - 3
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 3);

        System.out.println("DFS a partir do vértice 1:");
        g.dfs(1);  // Saída esperada (pode variar): 1 2 3 4
    }
}
