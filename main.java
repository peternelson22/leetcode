import java.util.*;

// 1. Contains duplicate - Given an array of numbers, return true if any value appears at least twice in the array and otherwise eg nums = [1,2,3,1] - true



// class ContainsDuplicate{
//     public static boolean isDuplicate(int[] arr){
//         Set<Integer> nums = new HashSet<>();
//             for(int i: arr){
//                 if(nums.contains(i)){
//                     return true;
//                 } 
//                 nums.add(i);
//             }
//             return false;
//     }
//     public static void main(String[] args){
//         int[] n = {1,2,3,4};
//         System.out.println(isDuplicate(n));
//     }
// }

// 2. Given two strings s and t, return true if t is an anagram of s and otherwise. An Anagram is a word or phrase formed by rearranging the letters of a dfferent word or phrase eg: s = "anagram", t = "nagaram" -> true

// class Anagram{
//     public static boolean isAnagram(String s, String t){
//         if(s.length() != t.length()){
//             return false;
//         }
//         char[] s1 = s.toCharArray();
//         char[] t1 = t.toCharArray();
        
//         Arrays.sort(s1); 
//         Arrays.sort(t1);

//        boolean ans = Arrays.equals(s1, t1) ? true : false;
//        return ans;
         
//     }
//     public static void main(String[] args){
//         System.out.println(isAnagram("anagram", "nagarnm"));
//     }
// }


// 3. Two sum problem - Given an arr of integers nums and an integer target, return indices of the two numbers such that they add up to target eg: nums = [2,7,11,15], target = 9 -> output = [0,1]
// import java.util.*;

// class TwoSum{
//     public static int[] twoSum(int[] nums, int t){
//         int size = nums.length;
//         for(int i = 0; i < size; i++){
//             for(int j = i + 1; j < size; j++){
//                 if (nums[i] + nums[j] == t){
//                     return new int[] {i, j};
//                 }
//             } 
//         }
//         return new int[]{};
//     }
//     public static void main(String[] args){
//         int[] arr = {3,2,4,8};
//         int[] store = twoSum(arr, 12);

//         System.out.println(Arrays.toString(store));
        
//     }
// }

// 4. Given an array of strings, group the anagrams together. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase. eg:["eat", "tan", "ate", "nat", "bat"] -> [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

// class GroupAnagram{
//     public static void main(String[] args){
//         String[] str = {"eat", "tan", "ate", "nat", "bat", "tea"};
//         System.out.println(anagrams(str));
//     }

//     public static List<List<String>> anagrams(String[] strs){
//         Map<String, List<String>> maps = new HashMap<>();
//         for(String s: strs){
//             char[] characters = s.toCharArray();
//             Arrays.sort(characters);

//             String sortedChar = new String(characters);

//             if(!maps.containsKey(sortedChar)){
//                 maps.put(sortedChar, new ArrayList<>());
//             }
//             maps.get(sortedChar).add(s);
//         }
//         return new ArrayList<>(maps.values());
//     }
// }

// 5. Given an integer arr of nums and an int k, return the k most frequent elements. eg: nums = [1,1,1,2,2,3], k = 2 -> [1,2]

// class TopFrequent{
//     public static void main(String[] args){
//         int[] arr = {1,1,1,2,2,3};
//         int[] ans = topKFrequent(arr, 2);
//         System.out.println(Arrays.toString(ans)); 
//     }

//     public static int[] topKFrequent(int[] nums, int k){
//         if(k == 0) return new int[]{};

//         Map<Integer, Integer> maps = new HashMap<>();

//         for(int i: nums){
//             maps.put(i, maps.getOrDefault(i,0) + 1);
//         } 
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> maps.get(b) - maps.get(a));
//         pq.addAll(maps.keySet());

//         int input = 0;
//         int[] output = new int[k];

//         while(input < k){
//             output[input] = pq.poll();
//             input++;
//         }
//         return output;
//     }
// }


// 6. Given an int of nums, return an array ans such that ans[i] is equal to the product of all the elements of nums execpt nums[i] 

// class ProductOfArrExceptSelf{
//     public static int[] productOfArr(int[] nums){
//         int[] arr = new int[nums.length];
//         int temp = 1;
//         for(int i=nums.length-1; i>=0; i--){
//             arr[i] = temp;
//             temp *= nums[i];
//         }
//         temp = 1;
//         for(int i=0; i<nums.length; i++){
//             arr[i] *= temp;
//             temp *= nums[i];
//         }
//         return arr;

//     }
//     public static void main(String[] args){
//         int[] p = {1,2,3,4};
//         System.out.println(Arrays.toString(productOfArr(p))); 
//     }


// }
// class ProductExceptSelf {
//     public static int[] productExceptSelf(int[] nums) {
//         int length = nums.length;
        
//         // Initialize arrays to store left and right products
//         int[] leftProducts = new int[length];
//         int[] rightProducts = new int[length];
        
//         // Initialize the first element of leftProducts and last element of rightProducts
//         leftProducts[0] = 1;
//         rightProducts[length - 1] = 1;
        
//         // Calculate left products
//         for (int i = 1; i < length; i++) {
//             leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
//         }
        
//         // Calculate right products
//         for (int i = length - 2; i >= 0; i--) {
//             rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
//         }
        
//         // Calculate the final result array
//         int[] ans = new int[length];
//         for (int i = 0; i < length; i++) {
//             ans[i] = leftProducts[i] * rightProducts[i];
//         }
        
//         return ans;
//     }

//     public static void main(String[] args) {
//         int[] nums = {1, 2, 3, 4};
//         int[] result = productExceptSelf(nums);

//         // Print the result array
//         for (int num : result) {
//             System.out.print(num + " ");
//         }
//     }
// }


// 7: Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules: 1. Each row must contain the digits 1-9 without repetition. 2: Each column must contain the digits 1-9 without repetition. 3: Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition

// class ValidSudoku{

//     public static boolean isValidSuduko(char[][] board){

//         // check the rows
//         for(int i = 0; i < 9; i++){
//             if(!validGroup(board[i])){
//                 return false;
//             }
//         }

//         // check rows
//         for(int i = 0; i < 9; i++){
//             char[] column = new char[9];
//             for(int j = 0; j < 9; j++){
//                 column[j] = board[j][i];
//             }
//             if(!validGroup(column)){
//                 return false;
//             }
//         }

//         // check subboxes
//         for(int i = 0; i < 9; i+=3){
//             for(int j = 0; j < 9; j+=3){
//                 char[] subbox = new char[9];
//                 int index = 0;
//                 for(int x = i; x < i + 3; x++){
//                     for(int y = j; y < j + 3; y++){
//                         subbox[index++] = board[x][y];
//                     } 
//                 }
//                 if(!validGroup(subbox)){
//                     return false;
//                 } 
//             } 
//         }
//         return true;
//     }
//     private static boolean validGroup(char[] group){
//         Set<Character> seen = new HashSet<>();

//         for(char c : group){
//             if(c != '.'){
//                 if(seen.contains(c)){
//                     return false;
//                 }
//                 seen.add(c);
//             }

//         }
//         return true;
//     }

//     public static void main(String[] args){
//            char[][] arr = {
//                 {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                 {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                 {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                 {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                 {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                 {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                 {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                 {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                 {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//         };

//         boolean result = isValidSuduko(arr);
//         System.out.println(result); 
//     }


// }


// 8. Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence eg: nums = [100,4,200,1,3,2] -> 4

// class LongestConsecutiveElement{
//     public static int printLongestSequence(int[] nums){
//         if(nums == null || nums.length == 0) return 0;
    

//         Set<Integer> numsSet = new HashSet<>();

//         for(int num: nums){
//             numsSet.add(num);
//         } 
//         int maxLength = 0;
//         for(int num: nums){
//             if(!numsSet.contains(num - 1)){
//                 int currentNum = num;
//                 int currentStreak = 1;

//                 while(numsSet.contains(currentNum + 1)){
//                     currentNum++;
//                     currentStreak++;
//                 }
//                 maxLength = Math.max(currentNum, currentStreak);
//             }
//         }
//         return maxLength;
//     }
//     public static void main(String[] args){
//         int[] arr = {100,4,200,1,3,2};
//         System.out.println(printLongestSequence(arr)); 
//     }
// }

// 9: Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings

// class EcoderDecoder{
//     private static final String DELIMITER = "%";

//     public static String encode(List<String> strs){
//         StringBuilder sb = new StringBuilder();
//         for(String str: strs){
//             String ecodedStr = str.replace(DELIMITER, "\\" + DELIMITER);
//             sb.append(ecodedStr).append(DELIMITER);
//         }
//         return sb.toString();
//     }

//     public static List<String> decode(String str){
//         List<String> decodedStrs = new ArrayList<>();

//         String[] ecodedArr = str.split(DELIMITER);

//         for(String ecodedStr: ecodedArr){
//             String decodeStr = ecodedStr.replace("\\" + DELIMITER, DELIMITER);
//             decodedStrs.add(decodeStr);
//         }
//         return decodedStrs;
//     }

//     public static void main(String[] args){
//         List<String> strs = List.of("Hello", "World", "!");
//         String ecodedStr = encode(strs);

//         List<String> decodeStrs = decode(ecodedStr);
//         System.out.println(decodeStrs);
//     }
// }

// 10: Given a string s, return true if is a palindrome, or false otherwise eg: s = "A man, a plan, a canal:panama"

class Palindrome{
    public static boolean isPalindrome(String s){
        String cleanedStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int start = 0;
        int end = cleanedStr.length() - 1;

        while(start < end){
            if(cleanedStr.charAt(start) != cleanedStr.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "A man, a plan, a canal:panama";
        System.out.println(isPalindrome(s));
    }
}





























