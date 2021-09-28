package study;

import java.util.Stack;

public class Q25ValidParentheses {
    public static void main(String[] args) {
        String str = "]}[{";
//		String str = "";
        System.out.println(isValid(str));
    }

    public static boolean mySolve(String s){
        if(s == null || s.length() < 2)
            return false;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c == '{' || c =='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())
                    return false;
                else if(c == ']' && stack.pop() !='[')
                    return false;
                else if(c == '}' && stack.pop() !='{')
                    return false;
                else if(c == ')' && stack.pop() !='(')
                    return false;
            }
        }
        return stack.isEmpty();

    }

    public static boolean solve(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            System.out.println("c: "+c);
            if(c=='(') {
                stack.push(')');
            }else if(c=='[') {
                stack.push(']');
            }else if(c=='{') {
                stack.push('}');
            }else if(stack.isEmpty()|| stack.pop() != c) {
                return false;
            }

        }
        return stack.isEmpty();
    }


    public static boolean isValid(String s) {
        if(s==null||s.length()%2==1)
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            System.out.println("s: "+s.length());
            char c = s.charAt(i);
            if(c=='['||c=='{'||c=='(')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                else if(c==']' && stack.pop()!='[')
                    return false;
                else if(c==')' && stack.pop()!='(')
                    return false;
                else if(c=='}' && stack.pop()!='{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
