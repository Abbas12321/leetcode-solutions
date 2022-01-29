class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int[] stack = new int[heights.length + 1];
        int p = -1;
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];
            while (p != -1 && cur < heights[stack[p]]) {
                int h = heights[stack[p--]];
                int w = p == -1 ? i : i - stack[p] - 1;
                maxArea = Math.max(maxArea,  h * w);
            }
            stack[++p] = i;
        }
        return maxArea;
    }
}
