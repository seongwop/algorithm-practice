class Solution {
    public int solution(String word) {
        int answer = 0;
        
        char[] alphabet = new char[]{'A', 'E', 'I', 'O', 'U'};
        int[] index = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (word.charAt(i) == alphabet[j]) {
                    index[i] = j + 1;
                }
            }
        }
        for (int i = 0; i < index.length; i++) {
            for (int j = 1; j < 5 - i; j++) {
                answer += (index[i] - 1) * Math.pow(5, j);
            }
            answer += index[i];
        }
        return answer;
    }
}