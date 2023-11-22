// You are given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window
import java.util.*;

class SlidingWindowMaximum{
 public static int[] maxSlidingWindow(int[] nums, int k){

    if (nums == null || nums.length == 0) {
            return new int[0];
    }

    int n = nums.length;
    int[] result = new int[n-k+1];
    int resultIndex = 0;

    Deque<Integer> deque = new ArrayDeque<>(); 

    for(int i=0; i<n; i++){
        while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
            deque.removeLast();
        }
        deque.addLast(i);

        if(deque.peekLast() <= i - k){
            deque.removeFirst();
        }
        // Process maximum for the current window
        if (i >= k - 1) {
            result[resultIndex++] = nums[deque.peekFirst()];
        }
    }
    return result;
 }  
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.print("Max Sliding Window: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    } 
}