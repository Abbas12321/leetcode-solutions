class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int two = 1;
        while(num > 0) {
            //if bit is 0 then flip and make binary of result
            if(num%2 == 0) {
                ans += two;
            }
            two *= 2;
            num /= 2;
        }
        return ans;
    }
}
