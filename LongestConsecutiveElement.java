// 8. Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence eg: nums = [100,4,200,1,3,2] -> 4
import java.util.*;

class LongestConsecutiveElement{
    public static int printLongestSequence(int[] nums){
        if(nums.length == 0 || nums == null) return 0;

        Set<Integer> hash = new HashSet<>();
        for(int num : nums){
            hash.add(num);
        }

        int maxLength = 0;
        for(int num : nums){
            if(!hash.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                while(hash.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                maxLength = Math.max(currentNum, currentStreak);
            }
        }
        return maxLength;
    }
    public static void main(String[] args){
        int[] arr = {100,4,200,1,3,2};
        System.out.println(printLongestSequence(arr)); 
    }
}