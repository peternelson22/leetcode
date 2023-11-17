// 3. Two sum problem - Given an arr of integers nums and an integer target, return indices of the two numbers such that they add up to target eg: nums = [2,7,11,15], target = 9 -> output = [0,1]
import java.util.*;

class TwoSum{
    public static int[] twoSum(int[] nums, int target){
        int size = nums.length;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}