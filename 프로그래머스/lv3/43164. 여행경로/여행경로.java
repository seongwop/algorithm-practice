import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            else return a[0].compareTo(b[0]);
        });
        String[] answer = {};
        boolean[] visited = new boolean[tickets.length];
        ArrayList<String> route = new ArrayList<>();
        route.add("ICN");
        dfs("ICN", tickets, visited, route, 0);
        answer = route.toArray(new String[0]);
        return answer;
    }
    
    void dfs(String dep, String[][] tickets, boolean[] visited, ArrayList<String> route, int count) {
        if (count == tickets.length) {
            found = true;
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(dep)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, visited, route, count + 1);
                if (found == true) return;
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        } 
    }
}