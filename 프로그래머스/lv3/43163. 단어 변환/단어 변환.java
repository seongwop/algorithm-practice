import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (check(begin, words[i])) {
                queue.add(i);
                visited[i]++;
            }
        }
        
        while (!queue.isEmpty()) {
            int wordIdx = queue.poll();
            if (words[wordIdx].equals(target)) {
                return visited[wordIdx];
            }
            for (int i = 0; i < words.length; i++) {
                if (visited[i] == 0 && check(words[wordIdx], words[i])) {
                    System.out.println(words[i]);
                    queue.add(i);
                    visited[i] = visited[wordIdx] + 1;
                }
            }
        }
        return 0;
    }
    
    public boolean check(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) cnt++;
        }
        if (cnt == 1) return true;
        else return false;
    }
}