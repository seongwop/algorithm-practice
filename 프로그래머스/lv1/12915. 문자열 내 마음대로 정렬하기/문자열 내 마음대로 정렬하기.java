import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {

        List<String> strList = new ArrayList<>();
        
        for (String str : strings)
            strList.add(str);
        
        Collections.sort(strList, (a, b) -> {
            if (a.charAt(n) == b.charAt(n))
                return a.compareTo(b);
            return a.charAt(n) - b.charAt(n);
        });

        int idx = 0;
        while (idx < strings.length) {
            for (String str : strList)
                strings[idx++] = str;
        }
         
             
        
        
        return strings;
    }
}