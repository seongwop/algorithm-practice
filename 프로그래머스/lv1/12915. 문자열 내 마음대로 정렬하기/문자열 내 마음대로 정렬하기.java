import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {

        // Comparator 인터페이스를 람다식으로 구현해서 정렬
        Arrays.sort(strings, (String a, String b) -> {
            if (a.charAt(n) == b.charAt(n))
                return a.compareTo(b);
            return a.charAt(n) - b.charAt(n);

        });

        return strings;
    }
}