package study;

import java.util.HashSet;
import java.util.Set;

public class Q7JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(solve(J, S));
        System.out.println(mySolve(J, S));

    }

    public static int mySolve(String jew, String stones) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (char jewel : jew.toCharArray()) {
            set.add(jewel);
        }

        for (char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                result++;
            }
        }
        return result;
    }

    public static int solve(String jew, String stone) {
        Set<Character> set = new HashSet<>();
        for (char jewel : jew.toCharArray()) {
            set.add(jewel); // a, A
        }

        int count = 0;
        for (char stoneChar : stone.toCharArray()) {
            System.out.println("stoneChar: " + stoneChar);
            if (set.contains(stoneChar)) {
                count++;
            }
        }
        return count;
    }
}
