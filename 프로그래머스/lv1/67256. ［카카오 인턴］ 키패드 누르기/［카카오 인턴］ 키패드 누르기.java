import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] array = new int[numbers.length][2];

        // numbers 배열에 있는 숫자들을 2차원 배열에서의 위치로 바꿔서 새로운 2차원 배열에 전부 저장
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                array[i][0] = 3;
                array[i][1] = 1;
            } else {
                array[i][0] = (numbers[i] - 1) / 3;
                array[i][1] = (numbers[i] - 1) % 3;
            }
        }
        
        // 왼손가락과 오른손가락의 첫 시작 위치
        int[] currentL = {3, 0};
        int[] currentR = {3, 2};
        
        for (int i = 0; i < numbers.length; i++) {
            // 1, 4, 7을 누를 경우 무조건 L
            if (Arrays.equals(array[i], new int[]{0, 0}) || Arrays.equals(array[i], new int[]{1, 0}) || Arrays.equals(array[i], new int[]{2, 0})) {
                currentL = array[i];
                answer += "L";
            // 3, 6, 9를 누를 경우 무조건 R
            } else if (Arrays.equals(array[i], new int[]{0, 2}) || Arrays.equals(array[i], new int[]{1, 2}) || Arrays.equals(array[i], new int[]{2, 2})) {
                currentR = array[i];
                answer += "R";
            // 가운데를 누를 경우  (왼손가락과 오른손가락으로부터 거리가 같을 경우, 한쪽이 더 클 경우)
            } else {
                if (Math.abs(array[i][0] - currentL[0]) + Math.abs(array[i][1] - currentL[1])
                        == Math.abs(array[i][0] - currentR[0]) + Math.abs(array[i][1] - currentR[1])) {
                    if (hand.equals("left")) {
                        currentL = array[i];
                        answer += "L";
                    } else {
                        currentR = array[i];
                        answer += "R";
                    }
                } else if (Math.abs(array[i][0] - currentL[0]) + Math.abs(array[i][1] - currentL[1])
                        < Math.abs(array[i][0] - currentR[0]) + Math.abs(array[i][1] - currentR[1])) {
                    currentL = array[i];
                    answer += "L";
                } else if (Math.abs(array[i][0] - currentL[0]) + Math.abs(array[i][1] - currentL[1])
                        > Math.abs(array[i][0] - currentR[0]) + Math.abs(array[i][1] - currentR[1])) {
                    currentR = array[i];
                    answer += "R";
                }
            }
        }
        return answer;
    }
}