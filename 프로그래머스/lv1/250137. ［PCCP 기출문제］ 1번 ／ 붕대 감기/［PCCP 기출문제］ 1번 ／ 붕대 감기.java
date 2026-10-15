class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // ((공격의 시간 간격 - 1) % 붕대 감기 완료 시간) x 추가 회복
        // 그 외 일반 회복
        // 중간에 0 아래로 내려가면 return -1
        int term = 0;
        int curHealth = health;
        for (int i = 0; i < attacks.length; i++) {
            if (i == 0) {
                term = attacks[0][0] - 1;
            } else {
                term = attacks[i][0] - attacks[i - 1][0] - 1;
            }
            int overhealedNum = term / bandage[0];
            curHealth += overhealedNum * (bandage[2]) + term * bandage[1];
            if (curHealth > health) curHealth = health;
            curHealth -= attacks[i][1];
            if (curHealth <= 0) return -1;
        }
        return curHealth;
    }
}