package LeetCode;

import java.util.*;

/*
Group Anagrams
 */
public class Q49 {

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> strMap = new HashMap<>();

        for(String str: strs){
            char[] tmpChar = str.toCharArray();
            Arrays.sort(tmpChar);

            String sortedKey = String.valueOf(tmpChar);
            if(!strMap.containsKey(sortedKey)){
                strMap.put(sortedKey , new ArrayList<>());
            }
            strMap.get(sortedKey).add(str);
        }

        return new ArrayList<>(strMap.values());
    }
}
