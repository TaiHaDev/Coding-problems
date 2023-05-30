package two_pointer;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater11().maxArea(heights));
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int leftVal = height[l];
            int rightVal = height[r];
            int curArea = Math.min(leftVal, rightVal) * (r - l);
            maxArea = Math.max(maxArea, curArea);
            if (leftVal > rightVal) r--;
            else l++;
        }
        return maxArea;
    }
}
