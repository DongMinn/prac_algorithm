package LeetCode;

import java.util.Arrays;

/**
 * Created by alvin on 2021/02/02.
 */
public class Q344 {

    public static void main(String[] args) {
        char[] chars  = {'h','e','l','l','o'};

        reverseString(chars);
    }

    public static void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
    public static void helper(char[] s , int left, int right){
        if(left>=right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;

        helper(s, left , right);
    }

}
