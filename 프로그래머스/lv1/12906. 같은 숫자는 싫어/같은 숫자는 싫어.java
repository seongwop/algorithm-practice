import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        // 인덱스 한칸 차이로 값이 달라질 경우 ArrayList에 추가
        for(int i  = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1])
                list.add(arr[i]);
        }
        
        // ArrayList 원소들을 배열로 복사
        int idx = 0;
        int[] answer = new int[list.size()];
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            answer[idx++] = iter.next();
        }
        return answer;
    }
}