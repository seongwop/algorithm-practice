class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int x = 0, y = 0;
        
        for (int i = 3; i * i <= brown + yellow; i++) {
            if ((brown + yellow) % i == 0) {
                y = i;
                x = (brown + yellow) / i;
                if (brown == 2 * x + 2 * (y - 2)) 
                    break;
            }
        }
        answer = new int[]{x, y};
        
        return answer;
    }
}