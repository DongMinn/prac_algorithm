package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q4DailyTemperature {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] res = dailyTemperatures(nums);
        int[] res = mySolve(nums);

        System.out.println("====result===");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            System.out.println("i:"+i+" "+temperatures[i]);
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ) {
                System.out.println("b: "+temperatures[i]);
                int index = stack.pop();
                System.out.println("index: "+index);
                System.out.println("i: "+i+" index "+index+" "+(i-index));
                ret[index] = i - index;
            }
            stack.push(i);
            System.out.println("");
        }
        return ret;
    }


    public static int[] mySolve(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        int count = 0;
        for (int temp : temperatures) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temp) {

                int index = stack.pop();
                result[index] = count - index;

            }
            stack.push(count);
            count++;
        }

        return result;
    }
}
