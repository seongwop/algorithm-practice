import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (left == right) {
                answer++;
                break;
            }
            if (people[left] + people[right] > limit) {
                answer++;
                right--;
            } else {
                answer++;
                left++;
                right--;
            }
        }
        return answer;
    }
}