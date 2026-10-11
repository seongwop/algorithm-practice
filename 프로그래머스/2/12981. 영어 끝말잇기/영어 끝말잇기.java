import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        // Set을 이용해서 존재할 경우 인덱스 계산 후 반환
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (wordSet.contains(words[i])
               || (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1))) {
                int num = (i + 1) % n == 0 ? n : (i + 1) % n;
                int order = (i + 1) % n == 0 ? (i + 1) / n : (i + 1) / n + 1;
                return new int[]{num, order};
            }
            wordSet.add(words[i]);
        }
        return new int[]{0, 0};
    }
}