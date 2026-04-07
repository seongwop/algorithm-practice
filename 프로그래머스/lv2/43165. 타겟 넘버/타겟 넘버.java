class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int cur, int target, int total) {
        if (cur == numbers.length) {
            if (target == total) answer++;
            return;
        }
        
        dfs(numbers, cur + 1, target, total + numbers[cur]);
        dfs(numbers, cur + 1, target, total - numbers[cur]);
    }
}