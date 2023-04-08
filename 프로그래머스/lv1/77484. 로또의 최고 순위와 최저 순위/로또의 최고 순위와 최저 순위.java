class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    
        int cnt = 0;
        int zeros = 0;
        
        // 당첨 숫자와 숫자 0 따로 카운트
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0)
                zeros++;
            for (int j = 0; j < win_nums.length; j++){
                if (lottos[i] == win_nums[j])
                    cnt++;
            }
        }

        // 최고 순위는 0이 전부 당첨 번호, 최저 순위는 0이 전부 틀린 번호
        int[] answer = {rank(cnt + zeros), rank(cnt)};
        return answer;
    }
    
    // 로또 순위 확인 메서드
    public int rank(int num) {
        int rank = 0;
         switch (num) {
            case 6 :
                rank = 1;
                break; 
            case 5:
                rank  = 2;
                break;
            case 4:
                rank  = 3;
                break;
            case 3:
                rank  = 4;
                break;
            case 2:
                rank  = 5;
                break;     
            default :
                rank  = 6;   
        }
        return rank;
    }
}