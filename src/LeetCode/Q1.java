package LeetCode;

import java.util.Arrays;

/**
 * Created by alvin on 2020/02/29.
 */
public class Q1 {

    public static void main(String[] args) {
//[2, 7, 11, 15], target = 9,

        int[] a = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(a, target)));

    }

    static public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]+nums[j] == target){
                    result[0] = j;
                    result[1] = i;
                    break;
                }
            }
        }

        return result;
    }
}
