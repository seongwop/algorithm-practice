import java.util.*;

class Solution {
    public int solution(int N, int number) {
        /* N개를 사용한 결과는 
        1개를 사용한 결과 (+, -, *, /) N - 1개를 사용한 결과
        2개를 사용한 결과 (+, -, *, /) N - 2개를 사용한 결과
        ...
        N - 1개를 사용한 결과 (+, -, *, /) 1개를 사용한 결과
        의 총합이므로 중복이 필요없는 Set에 각각의 결과를 List로 담음 */
        int answer = 0;
        ArrayList<Set<Integer>> setList = new ArrayList<>();
        // 8개까지만 유효
        for (int i = 1; i < 9; i++) {
            setList.add(new HashSet<>());
            // 각 Set에 개수만큼 N을 이어붙인 숫자를 원소로 가짐
            setList.get(i - 1).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        for (int i = 2; i < 9; i++) {
            Set<Integer> set = setList.get(i - 1);
            // n - m 와 m - n 의 결과는 다르기 때문에 preSet과 postSet으로 분리
            for (int j = 1; j < i; j++) {
                Set<Integer> preSet = setList.get(j - 1);
                Set<Integer> postSet = setList.get(i - j - 1);
                for (int a : preSet) {
                    for (int b : postSet) {
                        set.add(a + b);
                        set.add(a - b);
                        set.add(a * b);
                        if (a != 0 && b != 0) set.add(a / b);
                    }
                }
            }
        }
        for (int i = 1; i < 9; i++) {
            if (setList.get(i - 1).contains(number)) {
                answer += i;
                return answer;
            }
        }
        
        return -1;
    }
}