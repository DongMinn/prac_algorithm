package LeetCode;

/**
 * Created by alvin on 2020/04/14.
 */
//Sliding Window
//https://leetcode.com/problems/grumpy-bookstore-owner/
public class Q1052 {

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy =    {0,1,0,1,0,1,0,1};
        int x = 3;

        //16
        System.out.println(maxSatisfied(customers,grumpy,x));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        // precompute total satisfied customers
        // without shopkeeping using his power
        for (int i = 0; i < grumpy.length; ++i) {
            if (grumpy[i] == 0)
                total += customers[i];
        }

        // Now compute greatest additional satisfied
        // constomers using shopkeeper's power
        int greatest = 0;
        int running  = 0;
        for (int i = 0; i < customers.length; ++i) {
            // We should only affect unsatisfied customers
            if (grumpy[i] == 1) {
                running += customers[i];
            }
            if (i - X >= 0 && grumpy[i - X] == 1) {
                running -= customers[i - X];
            }
            greatest = Math.max(greatest, running);
        }

        return greatest + total;
    }
}
