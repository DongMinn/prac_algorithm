package LeetCode.LinkedList;

/*
Palindrome Linked List
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q234 {

    public static void main(String[] args) {


        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

//        System.out.println(isPalindrome(node1));
//        System.out.println(isPalindrome2(node1));
        System.out.println(isPalindrome3(node1));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;

        if (head == null) return false;
        if (head.next == null) return true;

        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        //reversing second half
        ListNode prev = null, next = null, current = slow;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        //comparing val from 1st half and reversed 2nd half
        while (prev != null) {
            if (prev.val != temp.val)
                return false;
            prev = prev.next;
            temp = temp.next;
        }
        return true;

    }

    public static boolean isPalindrome2(ListNode head) {

        if (head == null) return false;
        if (head.next == null) return true;

        ListNode tmp = head;
        List<Integer> arrayList = new ArrayList<>();

        while (tmp != null) {
            arrayList.add(tmp.val);
            tmp = tmp.next;
        }

        int length = arrayList.size() / 2;
        for (int i = 0; i < length; i++) {
            if (!arrayList.get(i).equals(arrayList.get(arrayList.size() - i - 1))) return false;
        }
        return true;
    }

    public  static boolean isPalindrome3(ListNode head){
        if(head == null)
            return true;
        ListNode fast = head, slow = head;

        /** find middle element */
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        /** when the length is odd */
        if(fast != null)
            slow = slow.next;

        /** reverse the second half */
        ListNode prev = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        /** compare the first and second half */
        slow = prev;
        while(slow != null) {
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
