class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            boolean[] connected = new boolean[n + 1];
            connected[wires[i][0]] = true;
            dfs(wires, connected, i, wires[i][0]);
            int count = 0;
            for (boolean c : connected) {
                if (c == true) count++;
            }
            int diff = Math.abs(n - count * 2);
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    
    void dfs(int[][] wires, boolean[] connected, int index, int node) {
        for (int i = 0; i < wires.length; i++) {
            if (i == index) {
                continue;
            }
            if (wires[i][0] == node && !connected[wires[i][1]]) {
                connected[wires[i][1]] = true;
                dfs(wires, connected, index, wires[i][1]);
            } else if (wires[i][1] == node && !connected[wires[i][0]]) {
                connected[wires[i][0]] = true;
                dfs(wires, connected, index, wires[i][0]);
            }
        }
    }
}