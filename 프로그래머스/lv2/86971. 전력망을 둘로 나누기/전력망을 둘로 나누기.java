class Solution {
    int result;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        if (n == 2) return 0;

        for (int i = 0; i < wires.length; i++) {
            result = 2;
            boolean[] visited = new boolean[wires.length];
            // 두 전력망으로 나뉘어지기 때문에 시작을 첫 번째 or 두 번째로 고정
            // 첫 번째를 끊을 경우 두 번째부터 조회, 나머지 경우 첫 번째부터 조회
            if (i == 0) {
                visited[1] = true;
                dfs(i, 1, wires, visited);
            }
            else {
                visited[0] = true;
                dfs(i, 0, wires, visited);
            }
            answer = Math.min(answer , Math.abs(n - 2 * result));
        }
        return answer;
    }
    // disconnect : 끊을 연결망, index : 다음 조회할 연결망
    void dfs(int disconnect, int index, int[][] wires,  boolean[] visited) {
        for (int i = 0; i < wires.length; i++) {
            if (i == disconnect || i == index) 
                continue;
            if (!visited[i]) {
                if (wires[i][0] == wires[index][1] || wires[i][0] == wires[index][0] || wires[i][1] == wires[index][1] || wires[i][1] == wires[index][0]) {
                    visited[i] = true;
                    result++;
                    dfs(disconnect, i, wires, visited);
                } 
            }
        }
    }
}