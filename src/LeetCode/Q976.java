package LeetCode;

import java.util.Arrays;

/**
 * Created by alvin on 2020/04/21.
 */
//Sort
public class Q976 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] A) {

        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i + 1] > A[i + 2])
                return A[i] + A[i + 1] + A[i + 2];
        return 0;
//        for (int i = A.length - 1; i >= 0; i--) {
//            if (A[i - 2] + A[i - 1] > A[i]) {
//                return A[i - 2] + A[i - 1] + A[i];
//            }
//        }
//        return 0;
    }
}
