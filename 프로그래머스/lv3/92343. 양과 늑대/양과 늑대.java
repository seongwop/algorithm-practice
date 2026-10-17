import java.util.*;

class Solution {
    public boolean[] visitedRoutes;
    public int maxSheep;
    
    public int solution(int[] info, int[][] edges) {
        
        // DFS + 메모이제이션 + 비트마스킹
        maxSheep = 1;
        visitedRoutes = new boolean[1 << info.length];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        dfs(info, graph, 1, 1, 0);
        
        
        return maxSheep;
    }
    
    void dfs(int[] info, List<List<Integer>> graph, int visitedNode, int sheep, int wolf) {
        if (visitedRoutes[visitedNode]) {
            return;
        }
        
        visitedRoutes[visitedNode] = true;
        for (int visited = 0; visited < info.length; visited++) {
            if ((visitedNode & (1 << visited)) == 0) {
                continue;
            }
            for (int nextNode : graph.get(visited)) {
                // 이미 방문한 노드
                if ((visitedNode & (1 << nextNode)) != 0) {
                    continue;
                }
                int nextSheep = sheep;
                int nextWolf = wolf;    
                
                if (info[nextNode] == 0) {
                    nextSheep++;
                    if (nextSheep > maxSheep) {
                        maxSheep = nextSheep;
                    }
                } else if (sheep - wolf > 1) {
                    nextWolf++;
                } else {
                    continue;
                }
                int nextVisited = visitedNode | (1 << nextNode);
                dfs(info, graph, nextVisited, nextSheep, nextWolf);
            }
        }
    
    }
}