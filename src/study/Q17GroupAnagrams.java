package study;

import java.util.*;

public class Q17GroupAnagrams {
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};


        System.out.println(groupAnagrams(list));

        System.out.println(mySolve(list));
        System.out.println(mySolve2(list));
    }

    public static List<List<String>> mySolve(String[] strs) {

        Map<String, List<String>> resultMap = new HashMap<>();

        for (String str : strs) {

            char[] tmpStr = str.toCharArray();
            Arrays.sort(tmpStr);

            String sortedKey = String.valueOf(tmpStr);

            if (!resultMap.containsKey(sortedKey)) {
                resultMap.put(sortedKey, new ArrayList<>());
            }
            resultMap.get(sortedKey).add(str);
        }

        return new ArrayList<>(resultMap.values());
    }

    public static List<List<String>> mySolve2(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();

        for (String str : strs) {

            char[] chars = new char[26];

            for(int i = 0; i< str.length(); i++){
                chars[str.charAt(i)-'a']++;
            }

            String keyValue = String.valueOf(chars);
            if(!resultMap.containsKey(keyValue)){
                resultMap.put(keyValue, new ArrayList<>());
            }
            resultMap.get(keyValue).add(str);
        }

        return new ArrayList<>(resultMap.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] arr = new char[256];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i)]++;
            }
            String ns = new String(arr);
            System.out.println("ns: " + ns);

            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(ns, al);
            }
        }
        result.addAll(map.values());
        return result;
//	        return new ArrayList<List<String>>(map.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
