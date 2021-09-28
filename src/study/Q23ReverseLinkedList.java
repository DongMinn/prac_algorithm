package study;

public class Q23ReverseLinkedList {

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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        printNode(l1);
        ListNode head = mySolve(l1);
//        ListNode head = reverseList(l1);
        printNode(head);

    }

    public static ListNode mySolve(ListNode current) {

        ListNode result = null;

        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = result;
            result = temp;
        }
        return result;

    }

    public static ListNode reverseList(ListNode current) {
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void printNode(ListNode head) {
        System.out.println("printNOde: ");
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }

}
