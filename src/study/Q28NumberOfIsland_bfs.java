package study;

import java.util.LinkedList;
import java.util.Queue;

public class Q28NumberOfIsland_bfs {
    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '1', '1'}
        };

//        System.out.println(solve(grid));
        System.out.println(mySolve(grid));
    }

    public static int mySolve(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void bfs(char[][] grid, int x, int y) {

        grid[x][y] = 'X';
        int height = grid.length;
        int width = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int[] dir : dirs) {
                int modifyX = location[0] + dir[0];
                int modifyY = location[1] + dir[1];

                if (modifyX >= 0 && modifyY >= 0 && modifyX < height
                        && modifyY < width && grid[modifyX][modifyY] == '1') {
                    grid[modifyX][modifyY] = 'X';
                    queue.offer(new int[]{modifyX, modifyY});
                }
            }
        }
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int m, n;

    public static int solve(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    solveBfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void solveBfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            //int size = queue.size();  //사이즈로 돌리는거 불필요함, 밑에 poll()에서 빼서 쓰면됨
            int[] p = queue.poll();
            //for( int i=0; i<size; i++) {//사이즈로 돌리는거 불필요
            for (int[] dir : dirs) {
                int dx = p[0] + dir[0];
                int dy = p[1] + dir[1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == '1') {
                    grid[dx][dy] = '0';
                    queue.offer(new int[]{dx, dy});
                }
            }
            //}
        }

    }
}
