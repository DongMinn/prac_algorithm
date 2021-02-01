package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alvin on 2020/04/21.
 */
//Union Find
//Disjoint-Set

public class Q684 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

//    public static int[] findRedundantConnection(int[][] edges) {
//        if (edges == null || edges.length == 0) {
//            return null;
//        }
//
//        Map<Integer, Integer> parents = new HashMap<>();
//        int[] result = new int[2];
//        for (int[] edge : edges) {
//            int x = edge[0];
//            int y = edge[1];
//            if (find(x, parents) == find(y, parents)) {
//                result[0] = x;
//                result[1] = y;
//            } else {
//                union(x, y, parents);
//            }
//        }
//
//        return result;
//    }
//
//    private static void union(int x, int y, Map<Integer, Integer> parents) {
//        if (!parents.containsKey(x)) {
//            parents.put(x, x);
//        }
//        if (!parents.containsKey(y)) {
//            parents.put(y, y);
//        }
//
//        int px = find(x, parents);
//        int py = find(y, parents);
//        parents.put(px, py);
//    }
//
//    private static int find(int x, Map<Integer, Integer> parents) {
//        int p = parents.getOrDefault(x, x);
//        if (x != p) {
//            int pp = find(p, parents);
//            parents.put(x, pp);
//        }
//
//        return parents.getOrDefault(x, x);
//    }

    public static int find(int[] parent, int node) {
        while (node != parent[node])
            node = parent[node];
        return node;
    }

    public static void union(int a, int b, int[] parent) {
        a = find(parent, a);
        b = find(parent, b);
        if (a == b)
            return;
        parent[a] = b;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            if (find(parent, edge[0]) == find(parent, edge[1]))
                return edge;
            union(edge[0], edge[1], parent);
        }
        return null;
    }

}
