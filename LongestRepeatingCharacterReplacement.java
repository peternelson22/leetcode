// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform the operation at most k times. Return the length of the longest substring containing the same letter you can get after performing the above operations.
import java.util.*;

class LongestRepeatingCharacterReplacement{
    public static int longestSubstring(String s, int k){
        int n = s.length();
        int start = 0;
        int maxCount = 0;
        int maxLength = 0;

        if(s == null || s.length() == 0 || k < 0){
            return 0;
        }
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for(int end=0; end<n; end++){
            char currentChar = s.charAt(end);
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);
            maxCount = Math.max(maxCount, charCountMap.get(currentChar));

            int windowLength = end - start + 1;

            if(windowLength - maxCount > k){
                charCountMap.put(s.charAt(start), charCountMap.get(s.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, windowLength);

        }
        return maxLength;
    }
    public static void main(String[] args) {
        String inputString = "ABAB";
        int k = 2;
        int result = longestSubstring(inputString, k);

        System.out.println("Length of the longest substring: " + result);
    }
}