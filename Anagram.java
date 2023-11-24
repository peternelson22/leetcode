// Given two strings s and t, return true if t is an anagram of s and otherwise. An Anagram is a word or phrase formed by rearranging the letters of a dfferent word or phrase
import java.util.*;
public class Anagram{
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        Map<Character, Integer> hash = new HashMap<>();
        for(char c: s.toCharArray()){
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        for(char c: t.toCharArray()){
            hash.put(c, hash.getOrDefault(c, 0) - 1);
        }
        for(int count: hash.values()){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
         System.out.println(isAnagram("anagram", "nagaram"));
     }
}