package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alvin on 2021/02/01.
 */
public class Q125 {
    public static void main(String[] args) {

        System.out.println(isPalindrome(""));

        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));

    }

    public static boolean isPalindrome(String s) {

        if (s.equals("") || s.length() == 1)
            return true;

        String str = s.toLowerCase();

        StringBuilder result = new StringBuilder();
        Matcher matcher = Pattern.compile("[a-zA-Z]").matcher(str);

        while (matcher.find()) {
            result.append(matcher.group());
        }

        String tmp = result.toString();
        if (tmp.length() == 1) {
            return false;
        }

        for (int i = 0; i < tmp.length() / 2; i++) {
            if (tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {

        Deque<String> deque = new ArrayDeque<>();

        if (s.equals("") || s.length() == 1)
            return true;

        String str = s.toLowerCase();
        Matcher matcher = Pattern.compile("[a-zA-Z]").matcher(str);

        while (matcher.find()) {
            deque.push(matcher.group());
        }

        if (deque.size() == 1) {
            return false;
        }

        for (int i = 0; i < deque.size() / 2; i++) {
            if (!Objects.equals(deque.pollFirst(), deque.pollLast())) {
                return  false;
            }
        }
        return true;
    }
}
