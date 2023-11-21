// Given a string s, find the length of the longest substring without repeating chararters
import java.util.*;
class LongestSubstringWIthoutRepeatingCharacters{

    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        int maxLength = 0;

        if (s == null || n == 0) {
            return 0;
        }

        HashSet<Character> charSet = new HashSet<>();

        for(int start=0, end=0; end<n; end++){
            char currentChar = s.charAt(end);

            while(charSet.contains(currentChar)){
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(currentChar);

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String inputString = "abcabcbb";
        int result = lengthOfLongestSubstring(inputString);

        System.out.println("Length of the longest substring without repeating characters: " + result);
    }

}