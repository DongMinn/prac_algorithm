package LeetCode;

/*
Maximum Product Subarray
 */
public class Q152 {
    public static void main(String[] args) {


        int[] arr = {-2,0,-1};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        int max= 0;

        int tmpProduct = 1;
        for(int j =0; j<nums.length; j++) {
            for (int i = j; i < nums.length; i++) {
                tmpProduct = tmpProduct * nums[i];
                max = Math.max(max, tmpProduct);
            }
            tmpProduct = 1;
        }

        return max;
    }

    public static int maxProduct2(int[] nums){
        if(nums.length == 0) return -1;
        int currMin = nums[0];
        int currMax = nums[0];
        int finalMax = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(Math.max(currMax * nums[i], currMin * nums[i]) , nums[i]);
            currMin = Math.min(Math.min(currMin * nums[i], temp * nums[i]), nums[i]);
            if(currMax > finalMax) finalMax = currMax;
        }
        return finalMax;
    }
}
