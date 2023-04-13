import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] array = new int[numbers.length][2];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                array[i][0] = 3;
                array[i][1] = 1;
            } else {
                array[i][0] = (numbers[i] - 1) / 3;
                array[i][1] = (numbers[i] - 1) % 3;
            }
        }
        
        int[] currentL = {3, 0};
        int[] currentR = {3, 2};
        
        for (int i = 0; i < numbers.length; i++) {
            if (Arrays.equals(array[i], new int[]{0, 0}) || Arrays.equals(array[i], new int[]{1, 0}) || Arrays.equals(array[i], new int[]{2, 0})) {
                currentL = array[i];
                answer += "L";

            } else if (Arrays.equals(array[i], new int[]{0, 2}) || Arrays.equals(array[i], new int[]{1, 2}) || Arrays.equals(array[i], new int[]{2, 2})) {
                currentR = array[i];
                answer += "R";

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