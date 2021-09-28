package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15FindAllAnagrams {
    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        System.out.println(findAnagrams(txt, pat));
        System.out.println(mySolve2(txt, pat));
    }

    public static List<Integer> mySolve2(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
            return result;

        int[] asciiToP = new int[256];
        for (int i = 0; i < p.length(); i++) {
            asciiToP[p.charAt(i)]++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] asciiToS = new int[256];

            for (int j = 0; j < p.length(); j++) {
                asciiToS[s.charAt(j + i)]++;
            }

            if(isAnagram(asciiToS , asciiToP)){
                result.add(i);
            }

        }

        return result;
    }

    public static boolean isAnagram(int[] s, int[] p) {

        for (int i = 0; i < s.length; i++) {
            if (s[i] != p[i]) {
                return false;
            }
        }
        return true;
    }


    public static List<Integer> mySolve(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
            return result;
        int patLength = p.length();

        char[] stringToChar = p.toCharArray();
        Arrays.sort(stringToChar);
        String sortedString = new String(stringToChar);


        char[] stringToCharTxt = s.toCharArray();

        for (int i = 0; i <= stringToCharTxt.length - patLength; i++) {

            String subTxt = s.substring(i, patLength + i);
            char[] stringToCharSubTxt = subTxt.toCharArray();
            Arrays.sort(stringToCharSubTxt);
            if (sortedString.equals(new String(stringToCharSubTxt))) {
                result.add(i);
            }

        }
        return result;
    }


    public static List<Integer> findAnagrams(String txt, String pat) {
        //1
        List<Integer> result = new ArrayList<>();
        if (txt == null || txt.length() == 0 || pat == null || pat.length() == 0 || txt.length() < pat.length())
            return result;
        //2
        int[] patArr = new int[256];//[0,0,0,0,0,0,1,1,1,1,0,0,0]
        for (int i = 0; i < pat.length(); i++) {
            patArr[pat.charAt(i)]++;
        }

        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            int[] txtArr = new int[256];
            for (int j = 0; j < pat.length(); j++) {
                txtArr[txt.charAt(i + j)]++; //0+, 1+
            }

            if (check(patArr, txtArr)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean check(int[] patArr, int[] txtArr) {
        for (int i = 0; i < patArr.length; i++) {
            if (patArr[i] != txtArr[i]) {
                return false;
            }
        }
        return true;
    }

}
