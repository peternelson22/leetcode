// Given an int of nums, return an array ans such that ans[i] is equal to the product of all the elements of nums execept nums[i] 
import java.util.*;

class ProductOfArrExceptSelf{
    public static int[] productOfArr(int[] nums){
        int n = nums.length;

        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        int leftProduct = 1;
        for(int i=0; i<n; i++){
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for(int i=n-1; i>=0; i--){
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = leftProducts[i] * rightProducts[i];
        } 

        return result;
    } 
     public static void main(String[] args){
         int[] p = {1,2,3,4};
         System.out.println(Arrays.toString(productOfArr(p))); 
     }
}