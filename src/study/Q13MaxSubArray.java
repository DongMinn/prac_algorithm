package study;

public class Q13MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(mySolve(nums));
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray_dp(nums));
    }

    public static int mySolve(int[] nums) {
        int result = nums[0];
        int newMax = nums[0];

        for (int i = 1; i < nums.length; i++) {

            newMax = Math.max(nums[i], newMax + nums[i]);
            result = Math.max(result, newMax);
        }


        return result;
    }


    public static int maxSubArray(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            newSum = Math.max(newSum + nums[i], nums[i]);
            max = Math.max(max, newSum);
        }
        return max;
    }

    public static int maxSubArray_dp(int[] A) {
        int n = A.length;
        int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
