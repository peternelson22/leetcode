// Given two strings s1 and s2, return true if s2 contains a permutation of s1 or false otherwise. 
import java.util.*;

class StringPermutation{
    public static boolean checkInclusion(String s1, String s2){
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        for(char ch : s1.toCharArray()){
            count1.put(ch, count1.getOrDefault(ch, 0) + 1);
        }
        // Initialize sliding window
        for(int i=0; i<s1.length(); i++){
            count2.put(s2.charAt(i), count2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        // Move sliding window through s2
        for(int i=s1.length(); i<s2.length(); i++){
            char enteringChar = s2.charAt(i);
            char leavingChar = s2.charAt(i - s1.length());

            // Update count for entering character
            count2.put(enteringChar, count2.getOrDefault(enteringChar, 0) + 1);

            // Update count for leaving character
            count2.put(leavingChar, count2.get(leavingChar) - 1);
            if(count2.get(leavingChar) == 0){
                count2.remove(leavingChar);
            } 

            // Check for permutation in the current window
            if(count1.equals(count2)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);

        System.out.println("Does s2 contain a permutation of s1? " + result);
    }
}