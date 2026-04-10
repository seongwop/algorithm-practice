class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] arr = new int[triangle.length][triangle.length];
        arr[0][0] = triangle[0][0];
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                arr[i + 1][j] = Math.max(arr[i + 1][j], arr[i][j] + triangle[i + 1][j]);
                arr[i + 1][j + 1] = Math.max(arr[i + 1][j + 1], arr[i][j] + triangle[i + 1][j + 1]);
            }
        }
        for (int i : arr[triangle.length - 1]) answer = Math.max(answer, i);
        return answer;
    }
}