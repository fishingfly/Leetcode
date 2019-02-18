package leetcode;

/**
 * @Auther: user
 * @Date: 2019/2/17 14:39
 * @Description:这是最笨的写法了
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int min = height[i] < height[j] ? height[i]: height[j];
                maxWater = min* (j - i) > maxWater ? min* (j - i) : maxWater;
            }
        }
        return maxWater;
    }

        public int maxArea_1(int[] height) {
            int maxarea = 0, l = 0, r = height.length - 1;
            while (l < r) {
                maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
                if (height[l] < height[r])
                    l++;
                else
                    r--;
            }
            return maxarea;
        }


}
