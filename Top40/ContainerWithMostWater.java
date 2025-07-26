// Container With Most Water
// Given: An array height[] where each element represents the height of a vertical line at that index on the x-axis.

// Goal: Find two lines that together with the x-axis form a container, such that the container holds the most water.

public class ContainerWithMostWater {
    //brute force : try all pairs of lines (i,j) and compute area -> keep max
    public static int maxAreaBruteForce(int height[]) {
        int maxArea = 0;
        int n = height.length;
        for(int i = 0; i< n; i++){
            for(int j = i+1; j<n;j++) {
                int area = Math.min(height[i], height[j]) * (j-i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    //optimised approach : 2 pointers , one at start , one at end. Move inward, always choosing the pointer at the smaller height since it limits the area
    public static int maxAreaOptmised(int height[]) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }
        return maxArea;
    }
}
