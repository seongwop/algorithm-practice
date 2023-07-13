class Solution {
    public int solution(String name) {

        int count = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            count += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endOfA = i + 1;
                while (endOfA < name.length() && name.charAt(endOfA) == 'A') {
                    endOfA++;
                }
                move = Math.min(move, i * 2 + name.length() - endOfA); // 오른쪽으로 가다가 왼쪽으로 꺾을 경우
                move = Math.min(move, (name.length() - endOfA) * 2 + i); // 왼쪽으로 가다가 오른쪽으로 꺾을 경우
            }
        }
        
        return count + move;
    }
}