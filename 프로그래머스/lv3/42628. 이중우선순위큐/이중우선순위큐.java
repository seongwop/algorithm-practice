import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] str = operation.split(" ");
            if (str[0].equals("I")) {
                pq1.offer(Integer.parseInt(str[1]));
                pq2.offer(Integer.parseInt(str[1]));
            } else if (str[0].equals("D") && str[1].equals("-1") && !pq1.isEmpty()) {
                pq2.remove(pq1.poll());
            } else if (str[0].equals("D") && str[1].equals("1") && !pq2.isEmpty()) {
                pq1.remove(pq2.poll());
            }
        }

        int[] answer = new int[2];
        if (!pq1.isEmpty() && !pq2.isEmpty()) {
            answer[0] = pq2.poll();
            answer[1] = pq1.poll();
        }
        return answer;
    }
}