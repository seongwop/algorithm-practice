import java.util.List;
import java.util.ArrayList;

class Solution {
    
// O(n^3) 풀이
//     public int solution(int n, int[][] wires) {
//         int answer = Integer.MAX_VALUE;
//         for (int i = 0; i < wires.length; i++) {
//             boolean[] connected = new boolean[n + 1];
//             connected[wires[i][0]] = true;
//             dfs(wires, connected, i, wires[i][0]);
//             int count = 0;
//             for (boolean c : connected) {
//                 if (c == true) count++;
//             }
//             int diff = Math.abs(n - count * 2);
//             answer = Math.min(answer, diff);
//         }
//         return answer;
//     }
    
//     void dfs(int[][] wires, boolean[] connected, int index, int node) {
//         for (int i = 0; i < wires.length; i++) {
//             if (i == index) {
//                 continue;
//             }
//             if (wires[i][0] == node && !connected[wires[i][1]]) {
//                 connected[wires[i][1]] = true;
//                 dfs(wires, connected, index, wires[i][1]);
//             } else if (wires[i][1] == node && !connected[wires[i][0]]) {
//                 connected[wires[i][0]] = true;
//                 dfs(wires, connected, index, wires[i][0]);
//             }
//         }
//     }
    
// 인접 리스트 적용을 통한 O(n^2) 풀이
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];
        int minDiff = n;
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        for (int[] wire : wires) {
            int count = dfs(wire[0], wire[1], graph, new boolean[n + 1]);
            
            int diff = Math.abs(n - 2 * count);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
    
    int dfs(int node, int disconnected, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : graph[node]) {
            if (neighbor == disconnected) {
                continue;
            }
            if (!visited[neighbor]) {
                count += dfs(neighbor, disconnected, graph, visited);
            }
        }
        return count;
    } 
}