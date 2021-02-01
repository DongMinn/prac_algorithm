package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by alvin on 2020/05/10.
 */
//Line Sweeping
public class Q1288 {
    public static void main(String[] args) {
        int[][] edges = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(removeCoveredIntervals(edges));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }

        // haha... haishi sort
        Arrays.sort(intervals, (i1, i2) -> (i1[0] != i2[0]) ? i1[0] - i2[0] :i2[1] - i1[1]);

        int countRemove = 0;
        int curMin = intervals[0][0];
        int curMax = intervals[0][1];

        for(int i=1;i<intervals.length;i++) {
            // no overlap, also refresh the current threshold..
            if(curMax < intervals[i][1]) {
                curMin = intervals[i][0];
                curMax = intervals[i][1];
            } else {
                // else, at least curMin < intervals[i][0]
                if(curMin <= intervals[i][0]) {
                    countRemove++;
                }
            }
        }
        return intervals.length - countRemove;
    }
}
