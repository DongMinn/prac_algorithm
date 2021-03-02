package LeetCode;

/*
Longest Palindromic Substring

슬라이딩 윈도우
다이내믹 프로그래밍

 */
public class Q5 {
    public static int lo;
    private static int maxLen;

    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));

    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo + maxLen);
    }

    public static void extendPalindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        if(maxLen < right-left -1){
            lo = left+1;
            maxLen = right-left -1;
        }
    }


}
