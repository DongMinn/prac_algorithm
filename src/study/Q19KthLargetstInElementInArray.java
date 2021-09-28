package study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q19KthLargetstInElementInArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(solve(nums, k));
        System.out.println(solve_pq(nums, k));
        System.out.println(mySolve(nums,k));
    }

    public static int mySolve(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int val:nums){
            pq.offer(val);
        }
        System.out.println(pq);
        int result = 0;
        for(int i = 0; i<k; i++){
            result = pq.poll();
        }
        return result;
    }

    public static int solve(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
//        print(nums);
        return nums[n - k];
    }

    public static void print(int[] nums) {
        for (int i : nums)
            System.out.println("i " + i);
    }

    public static int solve_pq(int[] nums, int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);

        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
