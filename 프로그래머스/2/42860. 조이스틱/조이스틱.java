class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endOfA = i + 1;
                while (endOfA < name.length() && name.charAt(endOfA) == 'A') endOfA++;
                move = Math.min(move, i * 2 + (name.length() - endOfA));
                move = Math.min(move, 2 * (name.length() - endOfA) + i);
            }
        }
        answer = answer + move;
        return answer;
    }
}