// Given an array of numbers, return true if any value appears at least twice in the array and otherwise eg nums = [1,2,3,1] - true
import java.util.*;
public class ContainsDuplicate{
    public static boolean containsDuplicate(int[] nums){
        Set<Integer> hash = new HashSet<>();
        for(int num: nums){
            if(hash.contains(num)){
                return true;
            }
            hash.add(num);
        }
        return false;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        boolean res = containsDuplicate(nums);
        System.out.println(res);
    }
}