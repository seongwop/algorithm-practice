import java.util.*;

class Solution {
    List<String> routes = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];

        dfs("ICN", tickets, visited, "ICN", 0);
        
        Collections.sort(routes);
        String[] answer = routes.get(0).split(" ");
        
        return answer;
    }
    
    void dfs(String start, String[][] tickets, boolean[] visited, String route, int count) {
        if (count == tickets.length) {
            routes.add(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], tickets, visited, route + " " + tickets[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}