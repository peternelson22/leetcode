// You are given an integer array height of length n. There are n verticallines drawn such that the two endpointsof the ith line are (i, 0) and (i, height[i])

class ContainerWithMostWater{
    public static int mostWater(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);

            maxArea = Math.max(maxArea, width*minHeight);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
     public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = mostWater(height);

        System.out.println("Maximum area between vertical lines: " + result);
    }
}