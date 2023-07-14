import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        // 두 문자열을 이어붙였을 때 큰 수를 기준으로 Comparator 구현
        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
        
        // [0, 0] 일 경우 답은 00이 아니라 0
        if (strings[0].equals("0")) return "0";

        StringBuilder stringBuilder = new StringBuilder();
        
        for (String str : strings) stringBuilder.append(str);

        return stringBuilder.toString();
    }
}