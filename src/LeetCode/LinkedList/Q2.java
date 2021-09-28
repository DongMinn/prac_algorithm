package LeetCode.LinkedList;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
Add Two Numbers
 */
public class Q2 {
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

        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(5, node2);

        ListNode b3 = new ListNode(3);
        ListNode b2 = new ListNode(4, b3);
        ListNode b1 = new ListNode(2, b2);


        addTwoNumbers(b1,node1);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null)
            return null;

        ListNode reverseNode1 = reverseNode(l1);
        ListNode reverseNode2 = reverseNode(l2);

        BigInteger intResult = nodeToInt(reverseNode1).add(nodeToInt(reverseNode2));

        return convertIntToListNode(intResult);
    }



    public static ListNode reverseNode(ListNode head) {
        if (head == null)
            return null;

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode tmpNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmpNode;
        }
        return prev;
    }

    public static BigInteger nodeToInt(ListNode head) {
        List<String> strList = new ArrayList<>();

        while (head != null) {
            strList.add(String.valueOf(head.val));
            head = head.next;
        }

        StringBuilder value = new StringBuilder();
        for (String s : strList) {
            value.append(s);
        }
        return new BigInteger(value.toString());
    }

    public static ListNode convertIntToListNode(BigInteger value) {
        ListNode result = new ListNode();
        ListNode cur = result;
        String[] strValue = String.valueOf(value).split("");
        for (int i = strValue.length - 1; i >= 0; i--) {

            cur.next = new ListNode(Integer.parseInt(strValue[i]));
            cur = cur.next;
        }

        return result.next;
    }
}
