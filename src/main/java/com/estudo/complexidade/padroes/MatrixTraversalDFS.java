package com.estudo.complexidade.padroes;

public class MatrixTraversalDFS {
    static int[][] matrix = {
        {1, 1, 0, 0},
        {0, 1, 0, 1},
        {1, 0, 0, 1},
        {0, 0, 1, 1}
    };

    static boolean[][] visited;

    // Busca em profundidade na matriz
    static void dfs(int row, int col) {
        // Verifica limites da matriz
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
            return;

        // Verifica se já foi visitado ou se é 0
        if (matrix[row][col] == 0 || visited[row][col])
            return;

        visited[row][col] = true;
        System.out.print("(" + row + "," + col + ") ");

        // Movimentos possíveis (4 direções)
        dfs(row - 1, col); // cima
        dfs(row + 1, col); // baixo
        dfs(row, col - 1); // esquerda
        dfs(row, col + 1); // direita
    }
    
    public static void main(String[] args) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        visited = new boolean[rows][cols];

        System.out.println("Travessia DFS da matriz:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    System.out.println(); // Nova linha a cada região
                }
            }
        }
    }
}


