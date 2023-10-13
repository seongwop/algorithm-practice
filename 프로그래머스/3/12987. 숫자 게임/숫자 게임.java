import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int indexA = 0;
        int indexB = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        while (true) {
            if (indexB == B.length) {
                break;
            }
            if (A[indexA] < B[indexB]) {
                indexA++;
                indexB++;
                answer++;
            } else {
                indexB++;
            }
        }
        return answer;
    }
}