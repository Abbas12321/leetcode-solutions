class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0, sum = 0;
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        index.put(0, -1);
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 1) {
                sum ++;
            }
            else {
                sum --;
            }
            if (index.containsKey(sum)) {
                res = Math.max(res, i - index.get(sum));
            } else {
                index.put(sum, i);
            }
        }
        return res;
    }
}
