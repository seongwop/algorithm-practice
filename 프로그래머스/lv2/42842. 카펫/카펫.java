class Solution {
    public int[] solution(int brown, int yellow) {
        int height = 0, width = 0;
        int carpetSize = brown + yellow;
        for (int i = 3; i <= (brown - 2) / 2; i++) {
            if (carpetSize % i == 0) {
                height = i;
                width = carpetSize / i;    
                if ((height - 2) * (width - 2) == yellow) {
                    break;
                }
            }
        }
        return new int[]{width, height};
    }
}