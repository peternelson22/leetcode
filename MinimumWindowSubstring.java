// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicats) is included in the window. If there is no substring, return empty string
import java.util.*;

class MinimumWindowSubstring{

    public static String minWindow(String s, String t){
        Map<Character, Integer> charCountT = new HashMap<>();
        Map<Character, Integer> windowChars = new HashMap<>();

        // count the chars of t
        for(char ch : t.toCharArray()){
            charCountT.put(ch, charCountT.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int requiredChars = charCountT.size();

        int minLen = Integer.MAX_VALUE;
        int minLenStart = 0;

        while(right < s.length()){
            char chRight = s.charAt(right);
            windowChars.put(chRight, windowChars.getOrDefault(chRight, 0) + 1);

            // Check if the current window covers all required characters
            if (charCountT.containsKey(chRight) && windowChars.get(chRight).equals(charCountT.get(chRight))) {
                requiredChars--;
            }

        
            // Try to minimize the window
            while (requiredChars == 0) {
                // Update minimum length and starting index of the substring
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLenStart = left;
                }

                // Contract the window from the left
                char chLeft = s.charAt(left);
                windowChars.put(chLeft, windowChars.get(chLeft) - 1);

                // Check if the removal affects the coverage of required characters
                if (charCountT.containsKey(chLeft) && windowChars.get(chLeft) < charCountT.get(chLeft)) {
                    requiredChars++;
                }

                // Move the left pointer to minimize the window
                left++;
            }

            // Expand the window from the right
            right++;
        }

        // Check if a valid substring is found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLenStart, minLenStart + minLen);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);

        System.out.println("Minimum Window Substring: " + result);
    }

}