package study;

import java.util.ArrayList;
import java.util.List;

public class Q20MissingRange {
    public static void main(String[] args) {

        int[] nums = {2, 3, 5, 50, 75};
        int lower = 0, upper = 99;
        System.out.println(solve(nums, lower, upper));
        System.out.println(mySolve(nums,lower,upper));

    }


    public static List<String> mySolve(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(showRange(lower, upper));
            return result;
        }


        if (lower < nums[0]) {
            result.add(showRange(lower, nums[0] - 1));
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                result.add(showRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        if (upper > nums[nums.length - 1]) {
            result.add(showRange(nums[nums.length -1] + 1, upper));
        }


        return result;
    }

    public static List<String> solve(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(showRange(lower, upper));
            return result;
        }

        // 1st step
        if (lower < nums[0]) {
            result.add(showRange(lower, nums[0] - 1));
        }

        // 2nd step
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] + 1 < nums[i + 1]) {
                result.add(showRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // 3rd step
        if (nums[nums.length - 1] < upper) {
            result.add(showRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    public static String showRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);

    }
}
