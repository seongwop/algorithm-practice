class Solution {
    public boolean solution(int x) {

        int temp = x; // x값을 임시 변수에 저장
        int num = 0;
        
        // x의 자릿수 합 더하기
        while (x > 0) {
            num += x % 10;
            x /= 10;
        }
        
        // 처음에 주어진 x값을 자릿수 합으로 나누는 경우
        if (temp % num == 0)
            return true;
        else
            return false;
    }
}