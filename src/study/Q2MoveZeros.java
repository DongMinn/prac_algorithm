package study;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(n)
 * 데이타  int[] nums = {0,3, 2, 0, 8, 5};
 * 를 for문으로 모두 순회해야되니까
 * Space Complexity : O(1).
 * 주어진 문제에서 int currentIndex = 0;
 * 상수는 하나만 사용했으니까
 */
public class Q2MoveZeros {

    public static void main(String args[]) {
        // 1
        int[] nums = { 0, 3, 2, 0, 8, 5 };
        mySolve(nums);
        // 2
        int currentIndex = 0;
        // 3
        for (int i = 0; i < nums.length; i++) {
            // 4
            if (nums[i] != 0) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        // 5
        while (currentIndex < nums.length) {
            nums[currentIndex] = 0;
            currentIndex++;
        }
        // 6
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }


    }


    public static void mySolve(int[] nums){

        List<Integer> result = new ArrayList<>();

        int zeroCount = 0;
        for(int num : nums){
            if(num != 0)
                result.add(num);
            else
                zeroCount++;
        }

        for(int i = 0 ; i<zeroCount; i++){
            result.add(0);
        }

        System.out.println(result);
    }

}
