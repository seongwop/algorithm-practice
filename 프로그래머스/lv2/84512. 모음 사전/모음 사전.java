import java.util.*;

class Solution {
    String[] alphabets = {"A", "E", "I", "O", "U"};
    ArrayList<String> al = new ArrayList<>();
    
    public int solution(String word) {
                
        dfs("", 0);
        
        return al.indexOf(word);
    }
    
    void dfs(String word, int count) {
        al.add(word);
        if (count == 5)
            return;
        for (int i = 0; i < 5; i++) 
            dfs(word + alphabets[i], count + 1);
    }
}