package study;

import LeetCode.LinkedList.Q2;

import java.util.List;

public class Q21AddTwoNumbers {

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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);
//        ListNode node = solve(l1, l2);

        ListNode node = mySolve(l1,l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode mySolve(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;

        int carry = 0;
        ListNode result = new ListNode();
        ListNode p3 = result;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

//            p3.val = carry % 10;
//            p3.next = new ListNode();

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry = carry / 10;
        }

//        if(carry == 0 && result.next.val == 0) result.next = null;
        if(carry==1) p3.next = new ListNode(1);

        return result.next;
    }

    public static ListNode solve(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;
        int carry = 0;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }
        if (carry == 1) p3.next = new ListNode(1);
        return newHead.next;
    }
}
