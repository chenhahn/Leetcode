class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0, area;
        while(i <= j){
            area = (j - i) * Math.min(height[i], height[j]);
            if(area > maxArea) maxArea = area;
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxArea;
    }
}