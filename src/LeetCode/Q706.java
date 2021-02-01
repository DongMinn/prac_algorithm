package LeetCode;

/**
 * Created by alvin on 2020/05/10.
 */
//Hash Map
public class Q706 {

    private static final int SIZE = 1024;
    private Node[] table = new Node[SIZE];

    private static class Node {
        int hash;
        int key;
        int value;
        Node next;

        public Node(int hash, int key, int value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Q706() {

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = hash(key);
        Node n = table[hash];

        if (n == null) {
            table[hash] = new Node(hash, key, value);
        } else if (n.key == key) {
            n.value = value;
        } else {
            while (n.next != null) {
                n = n.next;
                if (n.key == key) {
                    n.value = value;
                    return;
                }
            }
            n.next = new Node(hash, key, value);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node n = table[hash(key)];
        if (n == null)
            return -1;
        while (n.key != key) {
            n = n.next;
            if (n == null)
                return -1;
        }
        return n.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = hash(key);
        Node n = table[hash];

        if (n != null) {
            if(n.key == key){
                table[hash] = n.next;
            } else if (n.next != null) {
                Node pre = n;
                n = n.next;
                while (n.key != key){
                    pre = n;
                    n = n.next;
                    if(n == null)
                        return;
                }
                pre.next = n.next;
            }

        }
    }

    private int hash(int key) {
        return key & (SIZE - 1);
    }

}
