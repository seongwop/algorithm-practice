import java.util.*;

class Solution {
    int answer = 0;
    HashSet<Integer> visitedNumber = new HashSet<>();
    public int solution(String numbers) {
        
        char[] chars = numbers.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            HashSet<Integer> visitedIndex = new HashSet<>();
            dfs(i, chars, visitedIndex, stringBuilder);
        }
        return answer;
    }
    
    void dfs(int index, char[] chars, HashSet<Integer> visitedIndex, StringBuilder stringBuilder) {
        if (visitedIndex.size() == chars.length) return;

        if (!visitedIndex.contains(index)) {
            visitedIndex.add(index);
            stringBuilder.append(chars[index]);
            if (isPrime(Integer.parseInt(stringBuilder.toString()))) {
                answer++;
            }

            for (int i = 0; i < chars.length; i++) {
                dfs(i, chars, visitedIndex, stringBuilder);
            }
        } else {
            return;
        }
        visitedIndex.remove(index);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    boolean isPrime(int number) {
        if (!visitedNumber.add(number)) return false;
        if (number < 2) return false;
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}