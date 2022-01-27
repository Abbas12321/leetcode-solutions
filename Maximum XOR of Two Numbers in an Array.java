public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i --) {
            mask = mask|(1<<i);
            Set<Integer> prefix = new HashSet<Integer>();
            for (int j = 0; j < nums.length; j ++) {
                prefix.add(nums[j] & mask);
            }
            int cand = max|(1<<i);
            for (Integer pre:prefix) {
                if (prefix.contains(cand^pre)) {
                    max = cand;
                    break;
                }
            }
        }
        return max;
    }
}
