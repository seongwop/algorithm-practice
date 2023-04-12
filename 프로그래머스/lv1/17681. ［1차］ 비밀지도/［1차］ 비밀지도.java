class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] binaryArray1 = new int[n][n];
        int[][] binaryArray2 = new int[n][n];
        int[][] binaryResult = new int[n][n];
        
        String temp = "";
        // 각 원소를 2진수 배열로 바꿈
        for (int i = 0; i < n; i++) {
            binaryArray1[i] = toBinary(n, arr1[i]);
            binaryArray2[i] = toBinary(n, arr2[i]);
            // 겹치는 부분의 둘 중 하나라도 1이면 결과 배열에 1로 저장
            for (int j = 0; j < n; j++) {
                if (binaryArray1[i][j] == 1 || binaryArray2[i][j] == 1) binaryResult[i][j] = 1;
                // 정수 배열을 하나의 문자열로 변경
                temp += Integer.toString(binaryResult[i][j]);
            }
            // 문자열 치환
            answer[i] = temp;
            answer[i] = answer[i].replace("1", "#");
            answer[i] = answer[i].replace("0", " ");
            temp = "";
        }

        return answer;
    }
    // n과 값을 받아서 2진수로 변환한 배열로 바꿔주는 메서드
    public int[] toBinary (int n, int num) {
        int[] binaryArray = new int[n];

        for (int i = 0; i < n; i++) {
            if (num - Math.pow(2, n - 1 - i) >= 0) {
                binaryArray[i] = 1;
                num -= Math.pow(2, n - 1 - i);
            }
        }
        return binaryArray;
    }
}