class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        // 끝에 k - 1개의 숫자를 남겨둔 상태에서 최대값을 찾고 그 후로부터 범위를 변경
        for (int i = 0; i < number.length() - k; i++) {
            char max = 0;
            for (int j = start; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}