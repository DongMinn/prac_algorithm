package LeetCode;

/**
 * Created by alvin on 2020/04/06.
 */
public class Q11 {

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            System.out.println("l value:"+l);
            System.out.println("r value:"+r);
            System.out.println("l::"+height[l]);
            System.out.println("r::"+height[r]);
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
