class Solution {
public:
    
    int findMinArrowShots(vector<vector<int>>& points) {
        if(points.size() == 0) {
            return 0;
        }
        
        vector<pair<int, int>> mPoints;
        for(int i=0; i<points.size(); i++) {
            mPoints.push_back(make_pair(points[i][0], points[i][1]));
        }
        
        sort(mPoints.begin(), mPoints.end());
        
        vector<pair<int, int>> newPoints;
        newPoints.push_back(mPoints[0]);
        
        for(int i=1; i<mPoints.size(); i++) {
            pair<int, int> point1 = mPoints[i];
            pair<int, int> point2 = newPoints[newPoints.size()-1];
            pair<int, int> point3;
            if(point2.first <= point1.first && point2.second >= point1.first) {
                point3 = make_pair(min(point2.first, point1.first), min(point2.second, point1.second));
                newPoints[newPoints.size()-1] = point3;
            } else {
                newPoints.push_back(point1);
            }
        }
        return newPoints.size();
    }
};
