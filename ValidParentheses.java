// Given a string s containing just the chararcters '(', ')', '{', '}', '[', ']', determine if the input string is valid
import java.util.*;

class ValidParentheses{

    public  static boolean isValidParentheses(String s){
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Invalid character or mismatch
            }
        }
        return stack.isEmpty();
    }
     public static void main(String[] args) {
        String parenthesesString = "{[()]}";

        System.out.println(isValidParentheses(parenthesesString));
    }

}