
// 4. Given an array of strings, group the anagrams together. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase. eg:["eat", "tan", "ate", "nat", "bat"] -> [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
import java.util.*;

class GroupAnagram{
    public static List<List<String>> groupAnagram(String[] strs){
        Map<String, List<String>> hash = new HashMap<>();
        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);

            String sortedStr = new String(charArr);

            if(!hash.containsKey(sortedStr)){
                hash.put(sortedStr, new ArrayList<>());
                System.out.println(hash);
            }
            hash.get(sortedStr).add(s);
        }
        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args){
         String[] str = {"eat", "tan", "ate", "nat", "bat", "tea"};
         System.out.println(groupAnagram(str));
    }
}