class Solution {
    public int solution(int num) {
        
        int cnt = 0;
        
        for (int i = 0; i < 500; i++) {
            if (num == 1) // 주어진 수가 1인 경우
                return 0;
            if (num % 2 == 0) { // 주어진 수가 짝수인 경우
                num /= 2;
                cnt++;
            } else if (num % 2 == 1) { // 주어진 수가 홀수인 경우
                num = num * 3 + 1;
                cnt++;
            }
            if (num == 1) { // 작업 후에 1이 된 경우
                return cnt;
            }   
        }
        return -1; // 500번 동안 1이 되지 않은 경우
    }
}