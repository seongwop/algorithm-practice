class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    
        int cnt = 0;
        int zeros = 0;
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        // 당첨 숫자와 숫자 0 따로 카운트
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) zeros++;
            for (int j = 0; j < win_nums.length; j++){
                if (lottos[i] == win_nums[j]) cnt++;
            }
        }

        // 최고 순위는 0이 전부 당첨 번호, 최저 순위는 0이 전부 틀린 번호
        int[] answer = {rank[cnt + zeros], rank[cnt]};
        return answer;
    }
}