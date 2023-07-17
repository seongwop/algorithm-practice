import java.util.*;

class Solution {
    public int solution(int N, int number) {
        /* N개를 사용한 결과는 
        1개를 사용한 결과 (+, -, *, /) N - 1개를 사용한 결과
        2개를 사용한 결과 (+, -, *, /) N - 2개를 사용한 결과
        ...
        N - 1개를 사용한 결과 (+, -, *, /) 1개를 사용한 결과
        의 총합이므로 중복이 필요없는 Set에 각각의 결과를 List로 담음 */
        List<Set<Integer>> setList = new ArrayList<>();

        // 8개까지만 유효
        for (int i = 0; i < 8; i++) {
            setList.add(new HashSet<>());
            // 각 Set에 개수만큼 N을 이어붙인 숫자를 원소로 가짐
            setList.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i + 1)));
        }

        for (int i = 1; i < 8; i++) {
            Set<Integer> set = setList.get(i);
            // n - m 와 m - n 의 결과는 다르기 때문에 preSet과 postSet으로 분리
            for (int j = 0; j < i; j++) {
                Set<Integer> preSet = setList.get(j);
                Set<Integer> postSet = setList.get(i - j - 1);
                
                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);
                        if (preNum != 0 & postNum != 0) {
                            set.add(preNum / postNum);
                        }
                    }
                }
            }
        }
        for (Set<Integer> set : setList) {
            if (set.contains(number)) {
                return setList.indexOf(set) + 1;
            }
        }
        return -1;
    }
}