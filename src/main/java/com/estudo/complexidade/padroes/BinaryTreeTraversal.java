package com.estudo.complexidade.padroes;

import com.estudo.complexidade.dto.Node;

public class BinaryTreeTraversal {

 // Travessia em ordem (In-order): Esquerda → Raiz → Direita
 void inorder(Node node) {
     if (node == null) return;
     inorder(node.getLeft());
     System.out.print(node.getKey() + " ");
     inorder(node.getRight());
 }

 // Travessia pré-ordem (Pre-order): Raiz → Esquerda → Direita
 void preorder(Node node) {
     if (node == null) return;
     System.out.print(node.getKey() + " ");
     preorder(node.getLeft());
     preorder(node.getRight());
 }

 // Travessia pós-ordem (Post-order): Esquerda → Direita → Raiz
 void postorder(Node node) {
     if (node == null) return;
     postorder(node.getLeft());
     postorder(node.getRight());
     System.out.print(node.getKey() + " ");
 }

 public static void main(String[] args) {
     BinaryTreeTraversal tree = new BinaryTreeTraversal();

     // Construindo a árvore:
     //        1
     //       / \
     //      2   3
     //     / \
     //    4   5
     Node root = new Node(1);
     root.setLeft(new Node(2));
     root.setRight(new Node(3));
     root.getLeft().setLeft(new Node(4));
     root.getLeft().setRight(new Node(5));

     System.out.println("In-order traversal:");
     tree.inorder(root);   // Saída esperada: 4 2 5 1 3

     System.out.println("\nPre-order traversal:");
     tree.preorder(root);  // Saída esperada: 1 2 4 5 3

     System.out.println("\nPost-order traversal:");
     tree.postorder(root); // Saída esperada: 4 5 2 3 1
 }
}

