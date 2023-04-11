class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        // 제곱근이 1로 나누어 떨어질 경우만 약수가 홀수개
        for (int i = left; i < right + 1; i++) {
            if (Math.sqrt(i) % 1 == 0.0) answer -= i;
            else answer += i;
        }
        
        return answer;
    }
}