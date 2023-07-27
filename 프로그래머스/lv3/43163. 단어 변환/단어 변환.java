import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        int answer = bfs(begin, target, words);
        
        return answer;
    }
    
    int bfs(String begin, String target, String[] words) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[words.length];
        
        // begin이 배열에 있거나 없을 경우를 대비해 처음 queue에 한번 넣고 시작
        for (int i = 0; i < words.length; i++) {
            if (begin.equals(words[i])) {
                queue.clear();
                queue.offer(i);
                break;
            }
            if (change(begin, words[i])) {
                queue.offer(i);
                visited[i] = 1;
            }
        }
        
        while (!queue.isEmpty()) {
            int first = queue.poll();
            int current = visited[first];
            
            if (words[first].equals(target))
                return current;
            
            for (int i = 0; i < words.length; i++) {
                if (i != first && visited[i] == 0 && change(words[first], words[i])) {
                    queue.offer(i);
                    visited[i] = current + 1;
                }
            }
        }
        return 0;
    }
    
    // 변환 가능 확인
    boolean change(String word1, String word2) {
        int match = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i))
                match++;
        }
        if (match == word1.length() - 1)
            return true;
        return false;
    }
}