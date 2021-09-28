package study;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q22MergeKSortedList {

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
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        ListNode result = mergeKLists(list);
        System.out.println("====");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode mySolve(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode result = new ListNode(0);
        ListNode p = result;

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode pollNode = queue.poll();
            p.next = pollNode;
            p = p.next;

            if (pollNode.next != null) {
                queue.offer(pollNode.next);
            }
        }
        return result.next;
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        // 1
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comp);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }

        // 2
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            System.out.print("" + node.val + "\t");
            p.next = node;
            p = p.next;
            if (node.next != null)
                queue.offer(node.next);
        }
        return newHead.next;

    }

    static Comparator<ListNode> Comp = new Comparator<ListNode>() {

        @Override
        public int compare(ListNode a, ListNode b) {
            // TODO Auto-generated method stub
            return a.val - b.val;
        }

    };
}
