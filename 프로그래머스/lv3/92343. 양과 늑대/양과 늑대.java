import java.util.*;

class Solution {
    public static Set<Set<Integer>> visitedRoutes = new HashSet<>();
    public static int maxSheep = 1;
    
    public int solution(int[] info, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        dfs(info, graph, new HashSet<>(Arrays.asList(0)), 1, 0);
        
        
        return maxSheep;
    }
    
    void dfs(int[] info, List<List<Integer>> graph, Set<Integer> visitedNode, int sheep, int wolf) {
        if (visitedRoutes.contains(visitedNode)) {
            return;
        }
        
        visitedRoutes.add(visitedNode);
        for (int visited : visitedNode) {
            for (int nextNode : graph.get(visited)) {
                // 이미 방문한 노드
                if (visitedNode.contains(nextNode)) {
                    continue;
                }
                Set<Integer> nextVisited = new HashSet<>(visitedNode);
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
                nextVisited.add(nextNode);
                dfs(info, graph, nextVisited, nextSheep, nextWolf);
            }
        }
    
    }
}