import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
       
        // 중복을 없애주는 set 자료구조
        HashSet<Integer> set = new HashSet<>();
        
        // set에 모든 경우의 서로 다른 인덱스의 합 추가
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);        
            }
        }
        
        // list로 변환 및 오름차순 정렬
        ArrayList<Integer> list = new ArrayList<> (set);
        Collections.sort(list);
        
        // int형 배열 생성 및 복사
        int[] answer = new int[list.size()];
        int idx = 0;
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            answer[idx++] = iter.next();
        }
        
        // int[] answer = set.stream().sorted().mapToInt(Integer::intValue).toArray(); // Integer 형 Set -> 오름차순 int형 배열
        
        return answer;
    }
}