package LeetCode;

import java.util.Arrays;

/**
 * Created by alvin on 2020/03/17.
 */
public class Q912 {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(Arrays.toString(sortArray(a)));
    }

    static public int[] sortArray(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    static void quickSort(int left, int right, int[] nums) {
        int pivot = left;
        int j = pivot;
        int i = left + 1;

        if (left < right) {
            for (int k = i; k <= right; k++) {
                if (nums[k] < nums[pivot]) {
                    j++;
                    int tmp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = tmp;
                }
            }
            int tmp = nums[left];
            nums[left] = nums[j];
            nums[j] = tmp;
            pivot = j;

            quickSort(left, pivot - 1, nums);
            quickSort(pivot + 1, right, nums);
        }
    }


}
