package study;

public class Q27NumberOfIsland_dfs {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(grid.length);
        System.out.println(grid[0].length);
//        System.out.println(numsIslands(grid));

        System.out.println(mySolve(grid));
    }


    public static int mySolve(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public static void dfs(char[][] grid, int i, int j) {
        int height = grid.length;
        int width = grid[0].length;

        if (i < 0 || i >= height || j < 0 || j >= width || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = 'X';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
//
//    public static int numsIslands(char[][] grid) {
//        int m, n;
//        if(grid == null|| grid.length==0 || grid[0].length==0) return 0;
//        m = grid.length;
//        n = grid[0].length;
//        int count =0;
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<n; j++) {
//                if(grid[i][j]=='1') {
//                    count++;
//                    System.out.println("i: "+i+" y: "+j);
//                    merge(grid,i,j);
//                }
//            }
//        }
//        return count;
//    }
//    public static void merge(char[][] grid, int i, int j) {
//        System.out.println("==merge=====i: "+i+" y: "+j);
//        if(i<0 || i>=m || j<0||j>=n || grid[i][j]!='1') return ;
//        grid[i][j]='X';
////		for(int[] dir: dirs) {
////			merge(grid, i+dir[0], j+dir[1]);
////		}
//
//        merge(grid, i-1, j);
//        merge(grid, i+1, j);
//        merge(grid, i, j+1);
//        merge(grid, i, j-1);
//    }

}
