import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        dfs("", numbers);
        for (int i : set) {
            if (isPrime(i)) answer++;
        }
        return answer;
    }
    
    public void dfs(String combined, String others) {
        if (!combined.equals("")) set.add(Integer.parseInt(combined));
        for (int i = 0; i < others.length(); i++) {
            dfs(combined + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}