import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        List<Integer> intList = new ArrayList<>();
        
        int idx = 0;
        // commands에서 하나씩 뽑아서 조건 수행 후 ArrayList에 넣기
        for(int[] command : commands) {
            for (int i = command[0] - 1; i < command[1]; i++) {
                intList.add(array[i]);
            }
            // 정렬 후 특정 인덱스의 숫자 추출 후 ArrayList 리셋
            Collections.sort(intList);
            answer[idx++] = intList.get(command[2] - 1);
            intList.clear();
        }        
        return answer;
    }
}