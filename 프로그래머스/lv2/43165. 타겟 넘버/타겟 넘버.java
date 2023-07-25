class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
            
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    void dfs (int current, int sum, int[] numbers, int target) {

        if (current == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        // 인덱스를 한 칸씩 더해가며 덧셈 or 뺄셈
        dfs(current + 1, sum + numbers[current], numbers, target);
        dfs(current + 1, sum - numbers[current], numbers, target);
    }
}