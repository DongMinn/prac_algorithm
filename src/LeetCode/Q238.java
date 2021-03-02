package LeetCode;

import java.util.Arrays;

/*
Product of Array Except Self
 */
public class Q238 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    //space O(n)
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];


        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }


        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    //space O(1)
    public static int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int right = 1;

        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * right;

            right = right * nums[i];
        }


        return result;
    }

}
