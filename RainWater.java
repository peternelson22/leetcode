// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining

class RainWater{
    public static int maxRainTrapped(int[] height){
        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        int trappedWater = 0;

        while(left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(height[left] < height[right]){
                trappedWater += Math.max(0, maxLeft - height[left]);
                left++;
            }else{
                trappedWater += Math.max(0, maxRight - height[right]);
                right--;
            }
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        int[] elevationMap = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = maxRainTrapped(elevationMap);

        System.out.println("Trapped water: " + result);
    }
}