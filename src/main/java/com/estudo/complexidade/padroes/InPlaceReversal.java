package com.estudo.complexidade.padroes;

import com.estudo.complexidade.dto.ListNode;

public class InPlaceReversal {

	public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.getNext(); // guarda o próximo
            curr.setNext(prev);          // inverte o ponteiro
            prev = curr;               // avança o anterior
            curr = next;               // avança o atual
        }

        return prev; // novo head
    }
	
	public static ListNode reverseBetween(ListNode head, int left, int right) {
	    if (left == right) return head;

	    ListNode dummy = new ListNode(0);
	    dummy.setNext(head);
	    ListNode prev = dummy;

	    // 1️ Avança até o nó antes de 'left'
	    for (int i = 1; i < left; i++) {
	        prev = prev.getNext();
	    }

	    // 2️ Reverte o trecho entre left e right
	    ListNode curr = prev.getNext();
	    for (int i = 0; i < right - left; i++) {
	        ListNode next = curr.getNext();
	        curr.setNext(next.getNext());
	        next.setNext(prev.getNext());
	        prev.setNext(next);
	    }

	    return dummy.getNext();
	}

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.setNext(n2); n2.setNext(n3);

        ListNode reversed = reverseList(n1);
        while (reversed != null) {
            System.out.print(reversed.getVal() + " "); // 3 2 1
            reversed = reversed.getNext();
        }
    }
    
}
