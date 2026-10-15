import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        // 정렬 기준 1. 길이가 짧은 수열 2. 시작 인덱스가 작은 수열
        // 투 포인터
        List<int[]> candidates = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while (left <= right && right < sequence.length) {
            if (sum == k) {
                candidates.add(new int[]{left, right});
                sum -= sequence[left];
                left++;
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            }
        }
        Collections.sort(candidates, (a, b) -> {
            int compareLen = (a[1] - a[0]) - (b[1] - b[0]);
            int compareFirstIdx = a[0] - b[0];
            if (compareLen != 0) {
                return compareLen;
            }
            return compareFirstIdx;
        });
        
        return candidates.get(0);
    }
}