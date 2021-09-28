package study;

import java.util.Stack;

public class Q24BaseBallGame {
    public static void main(String[] args) {
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
//        System.out.println(calPoints(strs));
        System.out.println(mySolve(strs));
    }


    public static int mySolve(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int x = stack.pop();//가장 위에것
                    int y = stack.pop();//위에서 2번째 것
                    int sum = x + y;
                    stack.push(y);
                    stack.push(x);
                    stack.push(sum);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }

        int result = 0;
        while (!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x + y);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
