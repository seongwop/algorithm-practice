class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 나눴을 때 0으로 떨어지는 수가 약수
        for (int i = 1; i <= n; i ++) {
            if (n % i == 0.0) answer += i;
        }
        
        return answer;
    }
}