class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int num1 = 0;
        int num2 = 0;
        // 최대공약수이므로 마지막까지 공약수를 갱신
        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }
        // 최소공배수이므로 첫 공배수를 답에 넣고 끝냄
        for (int i = Math.max(n, m); i <= n * m; i++) {
            if (i % n == 0 && i % m ==0) {
                answer[1] = i;
                break;
            }        
        }
        return answer;
    }
}