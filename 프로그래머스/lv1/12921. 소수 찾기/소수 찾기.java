import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        // 에라토스테네스의 체 문제 - 소수의 배수를 전부 건너뛰면서 남은 숫자들이 소수
        
        // 인덱스를 숫자 값으로 여기고 소수가 true로 저장될 배열 생성
        boolean[] bool = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            // 원소값이 false로 남아있다면 소수 
            if (bool[i] == false) {
                answer++;
                // 소수의 배수를 전부 true로 변경
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