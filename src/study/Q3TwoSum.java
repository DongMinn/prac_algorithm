package study;


import java.util.HashMap;
import java.util.Map;

public class Q3TwoSum {


    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 21};
        int target = 23;
//        int[] result = solve(nums, target);

        int[] result = mySolve(nums, target);

        for (int i : result)
            System.out.println(i);
    }

    //
    public static int[] solve(int[] nums, int target) {
        //2.담을 그릇
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        //3.for
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int mapValue = map.get(nums[i]); //i=1일때 8 , map(8,0)
                result[0] = mapValue + 1; //1
                result[1] = i + 1;        //2
            } else {
                map.put(target - nums[i], i); //key 10-2=8, value i=0
            }
        }


        return result;

    }

    public static int[] mySolve(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        int[] result = new int[2];
        int count = 0;
        for (int num : nums) {

            if (resultMap.containsKey(num)) {
                result[0] = resultMap.get(num) + 1;
                result[1] = count + 1;

            } else {
                resultMap.put(target - num, count);
            }
            count++;
        }
        return result;
    }
}
