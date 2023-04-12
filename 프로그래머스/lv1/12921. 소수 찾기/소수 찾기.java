import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] bool = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            if (bool[i] == false) {
                answer++;
                for (int j = 2; j < n; j++) {
                    if (i * j > n) break;
                    bool[i * j] = true;
                }
            }
        }
        return answer;
    }

    // 해당 소수 찾기 메서드로는 효율성이 떨어짐
    // public boolean isPrime(int num) {
    //     for (int i = 2; i < num; i++) 
    //         if (num % i == 0) return false;
    //     return true;
    // } 
}