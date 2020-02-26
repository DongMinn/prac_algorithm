package LeetCode;

/**
 * Created by alvin on 2020/02/25.
 */
public class Q35 {
    public static void main(String[] args) {

        //[1,3,5,6], 5
        //[1,3,5,6], 7

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {

        //ver 1
//        int result = -1;
//        int anotherResult = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target)
//                result = i;
//        }
//
//        if(result == -1){
//            for(int i=0; i<nums.length;i++){
//                if (nums[i] > target) {
//                    anotherResult = i;
//                    break;
//                }
//                if (i == nums.length - 1 && nums[i] < target)
//                    anotherResult = i + 1;
//            }
//        }
//
//
//        return result == -1 ? anotherResult : result;

        //ver 2
        int result = -1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]>=target){
                result = i;
                break;
            }
        }

        return result == -1 ? nums.length: result;

    }
}
