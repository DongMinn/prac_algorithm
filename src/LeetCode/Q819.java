package LeetCode;

import java.util.*;

public class Q819 {


    public static void main(String[] args) {


        String[] strList = new String[1];
        strList[0] = "hit";
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",strList));
        System.out.println(mostWord("Bob hit a ball, the hit BALL flew far after it was hit.",strList));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). 공백으로 split  해서 word 찾아내기
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static String mostWord(String paragraph, String[] banned){

        String normalStr = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();

        String [] words = normalStr.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();
        for(String word: words){
            if(!Arrays.asList(banned).contains(word)){
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

}
