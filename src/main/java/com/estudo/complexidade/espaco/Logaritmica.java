package com.estudo.complexidade.espaco;

import com.estudo.complexidade.dto.Node;

public class Logaritmica {
	
	Node root;
	
	//insert só para montar a árvore
	void insert(int key) { root = insertRec(root, key); }
    private Node insertRec(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.getKey()) node.setLeft(insertRec(node.getLeft(), key));
        else if (key > node.getKey()) node.setRight(insertRec(node.getRight(), key));;
        return node;
    }
    
    public boolean buscaBSTRec(int target) {
    	// -------- BUSCA RECURSIVA (O(log n) espaço em árvore balanceada) --------
    	return buscaBST(root, target);
    }
    
	public static boolean buscaBST(Node raiz, int x) {
		if (raiz == null) return false;
		if (x == raiz.getKey()) return true;
		return (x < raiz.getKey()) ? buscaBST(raiz.getLeft(), x) : buscaBST(raiz.getRight(), x);
	}
	
	// -------- BUSCA ITERATIVA (O(1) espaço) --------
    boolean searchIterative(int target) {
        Node cur = root;
        while (cur != null) {
            if (target == cur.getKey()) return true;
            cur = (target < cur.getKey()) ? cur.getLeft() : cur.getRight();
        }
        return false;
    }
	
	public static void main(String[] args) {
		Logaritmica log = new Logaritmica();
		for (int v : new int[]{8,3,10,1,6,14,4,7,13}) {
			log.insert(v);
		}
		
		System.out.println("Resultado espaço O(log n): " + log.buscaBSTRec(7));
		System.out.println("Resultado espaço O(1): " + log.searchIterative(7));
    }

}
