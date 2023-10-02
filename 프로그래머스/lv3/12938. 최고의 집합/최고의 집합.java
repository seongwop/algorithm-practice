class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (s / n == 0) {
                return new int[]{-1};
            }
            answer[i] = s / n;
        }
        int remain = s - (s / n) * n;
        for (int i = 0; i < remain; i++) {
            answer[n - 1 - i] += 1;
        }
        return answer;
    }
}