class Solution {
public:
    int reverse(int x) {
        bool positive = true;
        int reminder;
        long num = (long)(x);

        if(num == 0) {
            return x;
        } else if (num < 0) {
            num = num * -1;
            positive = false;
        }

        int answer = 0;

        while (num != 0) {
            reminder = num % 10;

            if(answer > (INT_MAX/10) || (answer == (INT_MAX/10) && reminder > (INT_MAX%10))) {
                return 0;
            }

            answer = answer*10 + reminder;

            num = num/10;
        }

        return positive ? (int)(answer) : (int)(answer*-1);
    }
};
