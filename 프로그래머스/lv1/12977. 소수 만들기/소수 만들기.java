class Solution {
    public int solution(int[] nums) {
        
        int cnt = 0;
        
        // 원소 3개를 더해서 소수면 cnt++
        for (int i = 0; i < nums.length; i++) 
            for (int j = i + 1; j < nums.length; j++) 
                for (int k = j + 1; k < nums.length; k++) 
                    if (isPrime(nums[i] + nums[j] + nums[k])) cnt++;

        return cnt;
    }
    
    // 인자로 받는 정수가 소수인지 체크해주는 메서드
    public boolean isPrime(int num) {
        for (int i = 2; i < num; i++)
            if (num % i == 0) return false;
        return true;
    }
}