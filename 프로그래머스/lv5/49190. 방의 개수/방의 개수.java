import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        // 0~7 이동 방향 배열
        // 같은 정점을 다른 간선으로 만날 경우 방 + 1
        // 전체 좌표를 2배로 해서 0.5 단위 정점 발생 방지
        int[][] move = {
            {0, 1}, {1, 1}, {1, 0}, {1, -1}, 
            {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
        };
        Set<String> nodeSet = new HashSet<>();
        Set<String> edgeSet = new HashSet<>();
        nodeSet.add("0,0");
        int[] current = new int[]{0, 0};
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                String start = current[0] + "," + current[1];
                current = new int[]{current[0] + move[arrow][0], current[1] + move[arrow][1]};
                String next = current[0] + "," + current[1];
                String forward = start + "->" + next;
                String backward = next + "->" + start;
                if (nodeSet.contains(next) && !edgeSet.contains(forward) && !edgeSet.contains(backward)) {
                    answer++;
                }
                nodeSet.add(next);
                edgeSet.add(start + "->" + next);
                edgeSet.add(next + "->" + start);
            }
        }
            
        return answer;
    }
}