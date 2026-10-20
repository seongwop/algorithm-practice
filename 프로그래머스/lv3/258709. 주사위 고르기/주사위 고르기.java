import java.util.*;

class Solution {
    private int maxWin = 0;
    private int[] answer;
    
    public int[] solution(int[][] dice) {
        
        // 주사위 조합
        // 조합 별 숫자 덧셈 조합
        getComb(dice);
         
        return answer;
    }
    
    // 주사위 조합 생성 및 최대값 갱신
    void getComb(int[][] dice) {
        int n = dice.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) != n / 2) continue;
            
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    listA.add(i + 1);
                } else {
                    listB.add(i + 1);
                }
            }
        
            List<Integer> sumListA = getList(dice, new ArrayList<>(listA), new ArrayList<>(), 0, 0);
            List<Integer> sumListB = getList(dice, new ArrayList<>(listB), new ArrayList<>(), 0, 0);
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
                answer = listA.stream().mapToInt(i -> i).toArray();
                Arrays.sort(answer);
            }
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