import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for (int i : people) arr.add(i);
        while (!arr.isEmpty()) {
            if (arr.size() == 1) {
                answer++;
                return answer;
            }
            if (arr.peekFirst() + arr.peekLast() <= limit) {
                arr.pollFirst();
                arr.pollLast();
                answer++;
            } else {
                arr.pollLast();
                answer++;
            }
        }
        return answer;
    }
}