import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        arr = new int[] {4,1,2,3};
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
        System.out.println(min);
        
        int[] answer = new int[arr.length - 1];
        int index1 = 0;
        int index2 = 0;
        
        // 최솟값을 제외한 원소들 복사
        while (index1 < arr.length) {
            if (arr[index1] == min) {
                index1++;
            }
            answer[index2++] = arr[index1++];
        }
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}