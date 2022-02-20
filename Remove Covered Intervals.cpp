//time: O(NlogN), space: O(1)
class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        //sort left ascending, right descending
        sort(intervals.begin(), intervals.end(),
            [](const vector<int>& a, const vector<int>& b){
                return (a[0] == b[0]) ? a[1] > b[1] : a[0] < b[0];
                });
        
        int res = 0, right = -1;
        
        for(const vector<int>& v : intervals){
            if(v[1] > right){
                //in this case v[1] > right and v[0] > left
                ++res;
                right = v[1];
            }
            /*
            ignore these cases:
            1. v[0]==left && v[1]<=right:
            these intervals are covered by last interval
            2. v[0]>left && v[1]<=right:
            these intervals are covered by last interval
            */
        }
        
        return res;
    }
};
