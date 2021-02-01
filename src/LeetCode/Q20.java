package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by alvin on 2020/06/07.
 */

//Stack
public class Q20 {

    public static void main(String[] args) {

        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mapping.containsKey(c)) {

                char topChar = stack.isEmpty()?'#':stack.pop();

                if(topChar != mapping.get(c))
                    return false;

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
