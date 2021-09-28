package study;

import java.util.*;

public class Q12LongestSubMostTwoDist {
    public static void main(String[] args) {
        String s = "ccccffccx";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
        System.out.println(mySolve(s));
    }

    public static int mySolve(String s) {
        //내가 푼건.. 코드 보기엔 좀더 이해하기 쉬운거 같은데 내가 풀었으니..
        //근데 space 사용이 많아서.. 좋은 코드는 아니라고 봄.. 이걸 좀 더 업그레이드 하면 좋을거 같은데...
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);//내림차순
        char[] chars = s.toCharArray();


        Set<Character> distinctSet = new HashSet<>();


        for (int i = 0; i < chars.length; i++) {
            distinctSet.add(chars[i]);
            Set<Character> set = new HashSet<>();
            set.add(chars[i]);
            int setSize = set.size();
            int count = 0;
            for (int j = i; j < chars.length; j++) {

                set.add(chars[j]);
                if (setSize + 2 == set.size()) {
                    break;
                }
                count++;
                pq.offer(count);
            }
        }

        if (distinctSet.size() == 1)
            return 0;  //하나의 문자열만 있다면 0 을 리턴 해야 함.

        return pq.poll();
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) counter++;//new char
            end++;
            while (counter > 2) {
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if (map.get(cTemp) == 0) {
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end - start);
        }
        return len;
    }
}
