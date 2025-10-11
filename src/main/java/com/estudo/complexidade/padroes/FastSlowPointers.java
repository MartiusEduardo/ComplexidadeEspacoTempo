package com.estudo.complexidade.padroes;

import com.estudo.complexidade.dto.ListNode;

public class FastSlowPointers {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) return true; // encontraram-se ⇒ ciclo
        }
        return false;
    }
    
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1; // novo tamanho sem duplicados
    }

    public static void main(String[] args) {
    	//hasCycle
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(9);
        n1.setNext(n2); n2.setNext(n3); n3.setNext(n4); n4.setNext(n5); n5.setNext(n3); // ciclo
        System.out.println(hasCycle(n1)); // true
        
        //removeDuplicates
        int[] nums = {1, 1, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        System.out.println(len); // 4
    }
}
