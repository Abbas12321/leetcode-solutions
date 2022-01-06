class Solution {
    public boolean carPooling(int[][] trips, int capacity) {    
        int stops[] = new int[1001]; 
        for (int[] trip : trips) {
            // pick up
            stops[trip[1]] += trip[0];
            // drop off
            stops[trip[2]] -= trip[0];
        }

        int sum = 0;
        for (int i = 0; i < 1001; i++) {
            sum += stops[i];
            if (sum > capacity) {
                return false;
            }
        }
        return true; 
    }
}
