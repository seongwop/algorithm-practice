import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        ArrayList<Long> num = new ArrayList<>();
        int cnt = 0;
        
        while (n > 0) {
            num.add(n % 10);
            n /= 10;
        }
        Collections.sort(num);
        
        for (int i = 0; i < num.size(); i++){
            answer += num.get(i) * Math.pow(10, i);
        }
        return answer;
    }
}