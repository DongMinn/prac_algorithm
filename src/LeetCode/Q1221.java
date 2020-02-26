package LeetCode;

/**
 * Created by alvin on 2020/02/25.
 */
public class Q1221 {
    public static void main(String[] args) {

        int count = balancedStringSplit("RLRRRLLRLL");
        System.out.println(count);
    }

    public static int balancedStringSplit(String s) {
        //R혹은 L을 먼저 확인한다.
        //1. s의 전체 개수를 확인한다.
        // 2. 전체 개수를 반띵한다.
        int size = s.length();
        int result = 0;
        int rCount = 0;
        int lCount = 0;

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == 'R') {
                rCount++;
            } else {
                lCount++;
            }
            if (rCount == lCount)
                result++;
        }
        return result;

    }
}
