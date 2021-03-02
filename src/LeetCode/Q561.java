package LeetCode;

import java.util.Arrays;

/*
Array Partition1
 */
public class Q561 {

    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums) {


       int[] tmpNums = Arrays.stream(nums).sorted().toArray();
       int result = 0;
       for(int i=0; i<tmpNums.length; i++){
           if(i%2 == 0)
               result += tmpNums[i];
       }
        return result;
    }


    public static int arrayPairSum2(int[] nums){

        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i+=2) {
            sum+=nums[i];
        }

        return sum;
    }
}
