// Given an integer array nums, return all the triplets nums[i], nums[j], nums[k] such that i != j, i != k, and j 1= k and nums[i] +nums[j] + nums[k] == 0
import java.util.*;

class ThreeSum{
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }

                left++;
                right--;
                }
            }
        }
        return result;

    }
     public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);

        // Print the result
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
        // Output: [[-1, -1, 2], [-1, 0, 1]]
    }
}