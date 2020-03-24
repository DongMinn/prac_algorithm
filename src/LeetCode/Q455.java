package LeetCode;

import java.util.Arrays;

/**
 * Created by alvin on 2020/02/29.
 */

public class Q455 {

    public static void main(String[] args) {

        //[10,9,8,7]
        //[5,6,7,8]

        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};

        System.out.println(findContentChildren(g, s));
    }

    static public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        int count = -1;

        for (int value : g) {
            for (int j = 0; j < s.length; j++) {
                if (j > count) {
                    if (value <= s[j]) {
                        result++;
                        count = j;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
