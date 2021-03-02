package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alvin on 2020/02/29.
 */
public class Q1 {

    public static void main(String[] args) {
//[2, 7, 11, 15], target = 9,

        int[] a = {3,3};
        int target = 6;

        System.out.println(Arrays.toString(twoSum2(a, target)));

    }

    static public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = j;
                    result[1] = i;
                    break;
                }
            }
        }

        return result;
    }

    static public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int tmpKey = target - nums[i];
            if (map.containsKey(tmpKey)) {
                result[0] = map.get(tmpKey);
                result[1] = i;
                break;
            }else{
                map.put(nums[i],i);
            }

        }
        return result;
    }
}
