package LeetCode.LinkedList;

import javax.print.event.PrintEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvin on 2020/05/16.
 */
public class Q143 {
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

        ListNode node = new ListNode();
        node.val = 1;
        node.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));

        reorderList(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        int mid = (count + 1) / 2;

        node = head;

        while (mid > 1) {
            mid--;
            node = node.next;
        }

        ListNode second = node.next;
        node.next = null;

        ListNode first = head;

        node = first;
        second = reverse(second);

        while (second != null) {
            first = first.next;
            node.next = second;
            second = second.next;

            node = node.next;
            node.next = first;
            node = node.next;
        }

    }

    public static ListNode reverse(ListNode node) {
        ListNode left = null;
        ListNode current = node;
        ListNode right = node.next;

        while (right != null) {
            current.next = left;
            left = current;
            current = right;

            right = right.next;
        }

        current.next = left;
        return current;
    }
}
