import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        // 세로가 가로보다 클 경우 스왑
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) 
                swap(sizes[i]);
        }
        
        int max1 = sizes[0][0];
        int max2 = sizes[0][1];
        
        // 가로 중 최대값과 세로 중 최대값 계산
        for (int i = 1; i < sizes.length; i++) {
            if (sizes[i][0] > max1)
                max1 = sizes[i][0];
            if (sizes[i][1] > max2)
                max2 = sizes[i][1];
        }
        return max1 * max2;
    }
    
    // 배열의 원소 위치 스왑 메서드
    public void swap(int[] arr) {
        int temp;
        temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
}