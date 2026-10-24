import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int cols = relation[0].length;
        List<Integer> can = new ArrayList<>();
        
        for (int i = 1; i < (1 << cols); i++) {
            List<Integer> comb = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                if ((i & (1 << j)) != 0) {
                    comb.add(j);
                }
            }
            if (isCandidateKey(comb, relation)) {
                can.add(i);
            }
            
        }
        
        for (int i = 0; i < can.size(); i++) {
            boolean isMinimal = true;
            for (int j = 0; j < can.size(); j++) {
                if (i == j) continue;
                int A = can.get(i);
                int B = can.get(j);
                if ((A & B) == B) {
                    isMinimal = false;
                    break;
                } 
            }
            if (isMinimal) answer++;
        }
        return answer;
    }
    
    boolean isCandidateKey(List<Integer> comb, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (String[] arr : relation) {
            String str = "";
            for (int index : comb) {
                str += arr[index] + "/";
            }
            if (set.contains(str)) {
                return false;
            }
            set.add(str);
        }
        return true;
    }
}