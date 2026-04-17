import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) answer++;
        }
        if (answer > nums.length / 2) return nums.length / 2;
        else return answer;
    }
}