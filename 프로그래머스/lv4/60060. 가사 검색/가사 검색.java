import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        List<String>[] list = new ArrayList[10001];
        List<String>[] reverseList = new ArrayList[10001];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }
        for (String word : words) {
            int len = word.length();
            list[len].add(word);
            reverseList[len].add(reverse(word));
        }
        for (int i = 0; i < list.length; i++) {
            list[i].sort((a, b) -> a.compareTo(b));
            reverseList[i].sort((a, b) -> a.compareTo(b));
        }
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();
            List<String> wordList = list[len];
            if (wordList.size() == 0) {
                answer[i] = 0;
                continue;
            }
            // 앞부분이 와일드카드일 경우 문자열 뒤집기
            if (query.charAt(0) == '?') {
                query = reverse(query);
                wordList = reverseList[len];
            }
            
            String start = query.replace("?", "a");
            String end = query.replace("?", "z");
            // lower bound 찾기
            int left = 0;
            int right = wordList.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (start.compareTo(wordList.get(mid)) <= 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int lb = left;
            
            // upper bound 찾기
            int left2 = 0;
            int right2 = wordList.size() - 1;
            while (left2 <= right2) {
                int mid2 = left2 + (right2 - left2) / 2;
                if (end.compareTo(wordList.get(mid2)) < 0) {
                    right2 = mid2 - 1;
                } else {
                    left2 = mid2 + 1;
                }
            }
            int ub = left2;
            
            answer[i] = ub - lb;
        }
        return answer;
    }
    
    String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}