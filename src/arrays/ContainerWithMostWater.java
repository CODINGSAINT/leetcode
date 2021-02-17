package arrays;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int st = 0;
        int end = height.length - 1;
        //
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int currentArea = 0;
            int startWall = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int endWall = height[j];
                currentArea = Math.max(currentArea, Integer.min(startWall, height[j]) * (j - i));
            }
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;

    }

}
