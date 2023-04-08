class Solution {
    public int solution(int num) {
        
        int cnt = 0;
        for (int i = 0; i < 500; i++) {
            if (num == 1)
                return 0;
            if (num % 2 == 0) {
                num /= 2;
                cnt++;
            } else if (num % 2 == 1) {
                num = num * 3 + 1;
                cnt++;
            }
            if (num == 1) {
                return cnt;
            }
            
        }
        
        return -1;
    }
}