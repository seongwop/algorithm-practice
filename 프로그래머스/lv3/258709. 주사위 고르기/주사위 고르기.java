import java.util.*;

class Solution {
    private int maxWin = 0;
    private int[] answer;
    
    public int[] solution(int[][] dice) {
        
        // 주사위 조합
        // 조합 별 숫자 덧셈 조합
        getComb(dice, 1, new HashSet<>());
         
        return answer;
    }
    
    // 주사위 조합 생성 및 최대값 갱신
    void getComb(int[][] dice, int start, Set<Integer> setA) {
        if (setA.size() == dice.length / 2) {
            Set<Integer> setB = new HashSet<>();
            for (int i = 1; i <= dice.length; i++) {
                if (!setA.contains(i)) {
                    setB.add(i);
                }
            }
            List<Integer> sumListA = getList(dice, new ArrayList<>(setA), new ArrayList<>(), 0, 0);
            List<Integer> sumListB = getList(dice, new ArrayList<>(setB), new ArrayList<>(), 0, 0);
            Collections.sort(sumListA);
            Collections.sort(sumListB);
            
            int win = 0;
            
            // 각 합에 대해 이분탐색을 통해 몇개 이길 수 있는지 탐색
            for (Integer numA : sumListA) {
                int left = 0;
                int right = sumListB.size() - 1;
                // lower bound 탐색
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (sumListB.get(mid) >= numA) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                win += left;
            }
            if (maxWin < win) {
                maxWin = win;
                answer = setA.stream().mapToInt(i -> i).toArray();
                Arrays.sort(answer);
            }
            return;
        }
        
        for (int i = start; i <= dice.length; i++) {
            if (setA.contains(i)) continue;
            setA.add(i);
            getComb(dice, i + 1, setA);
            setA.remove(i);
        }
    }
    
    // 주사위 조합을 받고 합의 모든 조합 반환
    List<Integer> getList(int[][] dice, List<Integer> diceList, List<Integer> sumList, int sum, int diceIdx) {
        if (diceIdx == diceList.size()) {
            sumList.add(sum);
            return sumList; 
        }
        for (int diceNum : dice[diceList.get(diceIdx) - 1]) {
            getList(dice, diceList, sumList, sum + diceNum, diceIdx + 1);
        }
        return sumList;
    }
} 