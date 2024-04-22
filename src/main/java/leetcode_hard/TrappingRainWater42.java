package leetcode_hard;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater42().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public int trap(int[] height) {
        List<int[]> waterTrap = new ArrayList<>();
        int l = 0, r = 1;
        while (l < height.length) {
            while(r < height.length && height[r] <= height[r - 1]) {
                r++;
            }
            while(r < height.length && height[r] >= height[r - 1]) {
                r++;
            }
            waterTrap.add(new int[] {l, r});
            l=r;
        }
        int i = 1;
        while (i < waterTrap.size()) {
            if (waterTrap.get(i)[1] > waterTrap.get(i - 1)[1] && waterTrap.get(i-1)[1] <= waterTrap.get(i-1)[0]) {
                waterTrap.get(i-1)[1] = waterTrap.get(i)[1];
                waterTrap.remove(i);
            } else {
                i++;
            }
        }
        int res = 0;
        for (int[] interval : waterTrap) {
            int sum = 0;
            int min = Math.min(interval[0], interval[1]);
            for (int start = interval[0] + 1; start < interval[1]; start++) {
                sum += min - height[start];
            }
            res+= sum;
        }
        return res;
    }
}
