import java.util.Arrays;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] edge: costs) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];
            
            if (find(start) != find(end)) {
                union(start, end);
                answer += cost;
            }
        }
        return answer;
    }
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
    
        
}