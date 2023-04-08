import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        // return이 빈 배열일 경우
        if (arr.length <= 1) {
            int[] answer = {-1};
            return answer;
        }
    
        // arr 배열의 최솟값 구하기
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        int[] answer = new int[arr.length - 1];
        int index = 0;
        
        // 최솟값을 제외한 원소들 복사
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) 
                continue;
            answer[index++] = arr[i];
        }
        return answer;
    }
}