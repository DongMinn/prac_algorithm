package study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q9KClosets {
    public static void main(String[] args) {
//        int[][] points = {{1, 3}, {-2, 2}};
//        int k = 1;

        System.out.println("=");
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        print(points);
        System.out.println("===result==");
//        int[][] result = solve(points, k);
        print(mySolve(points, k));
//        print(result);
    }


    public static int[][] mySolve(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));

        int[][] result = new int[k][2];

        for (int[] point : points) {
            pq.offer(point);
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static int[][] solve(int[][] points, int k) {
//		Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        int[][] result = new int[k][2];
        int index = 0;

        for (int[] p : points) {
            queue.offer(p);
        }
        while (index < k) {
            result[index] = queue.poll();
            index++;
        }
        return result;

    }

    static Comparator<int[]> Comp = new Comparator<int[]>() {

        @Override
        public int compare(int[] a, int[] b) {
            // TODO Auto-generated method stub
            return (a[0] * a[0] + a[1] + a[1]) - (b[0] * b[0] + b[1] * b[1]);
        }

    };

    /*참고
     * Time: O(NlogN)
     */
    public static int[][] solve_2(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void print(int[][] result) {
        int m = result.length;
        int n = result[0].length;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(" [" + i + "][" + j + "] " + result[i][j]);
            }
            System.out.println();
        }
    }
}
