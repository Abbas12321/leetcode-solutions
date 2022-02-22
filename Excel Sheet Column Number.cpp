class Solution {
public:
    int titleToNumber(string s) {
        
        int power=0, colnum=0;

        while(!s.empty()) {

            colnum += (s[s.size()-1] - 'A' + 1)*pow(26, power);
            power++;
            s=s.substr(0, s.size()-1);

        }

        return colnum;
    }
};
