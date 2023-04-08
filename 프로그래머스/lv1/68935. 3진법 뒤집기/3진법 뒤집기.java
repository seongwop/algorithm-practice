class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int num = 0;
        int swap = 0;
        
        // 3진법으로 변환 시 자릿수 구하기
        while (n / (int)Math.pow(3, num) > 0) {
            num++;
        }
        // 자릿수로 할당된 배열에 n을 3진법으로 변환한 값 넣기
        int[] result = new int[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            result[i] = n / (int)Math.pow(3, num - 1 - i);
            n -= result[i] * (int)Math.pow(3, num - 1 - i);
        }
        // 배열 앞뒤 반전
        for (int i = 0; i < result.length / 2; i++) {
            swap = result[i];
            result[i] = result[result.length - 1- i];
            result[result.length - 1- i] = swap;
        }
        // 10진법으로 변환
        for (int i = 0; i < result.length; i++) {
            answer += result[i] * (int)Math.pow(3, result.length - 1 - i);
        }
        
        return answer;
    }
}