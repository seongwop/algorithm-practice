import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 중복을 제거해주는 HashSet 생성
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums) set.add(num);
        
        // set의 사이즈가 뽑고자하는 수보다 작으면 set 원소의 개수, 크면 최대로 뽑을 수 있는 수
        if (set.size() <= nums.length / 2) answer = set.size();
        else if (set.size() > nums.length / 2) answer = nums.length / 2;
        
        return answer;
    }
}