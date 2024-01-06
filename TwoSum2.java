// Given an index array of integers nums that is already sorted in non-decresaing order, find two numbers such that they add up to a specific target number
import java.util.*;

class TwoSum2{
    public static int[] twoSum2(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
        int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{nums[left], nums[right]};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
            
        }
        return new int[]{-1,-1};
    }
     public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum2(nums, target);

        // Print the result
        
        System.out.println(Arrays.toString(result));
        
    }
}