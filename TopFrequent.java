// 5. Given an integer arr of nums and an int k, return the k most frequent elements. eg: nums = [1,1,1,2,2,3], k = 2 -> [1,2]
import java.util.*;

class TopFrequent{
    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,3};
        int[] ans = topKFrequent(arr, 2);
        System.out.println(Arrays.toString(ans)); 
    }

    public static int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> hash = new HashMap<>();

        for(int num : nums){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hash.get(b) - hash.get(a));
        pq.addAll(hash.keySet());

        int input = 0;
        int[] output = new int[k];

        while(input < k){
            output[input] = pq.poll();
            input++;
        }
        return output;
    }
}