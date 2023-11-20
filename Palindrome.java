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