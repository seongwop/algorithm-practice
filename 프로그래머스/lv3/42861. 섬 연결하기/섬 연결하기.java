import java.util.*;

class Solution {
    static int[] root = new int[100];
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        return kruskal(costs);
    }
    
    public int kruskal(int[][] costs) {
        int cost = 0;
        for (int i = 0; i < costs.length; i++) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                cost += costs[i][2];
            }
        }
        return cost;
    }
    
    public void union(int x, int  y) {
        x = find(x);
        y = find(y);
        if (x > y) root[x] = y;
        else root[y] =  x;
    }
    
    public int find(int x) {
        if (root[x] == x)
            return x;
        else
            return find(root[x]);
    }
}