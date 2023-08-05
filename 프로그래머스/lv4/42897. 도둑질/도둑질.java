class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] visitFirst = new int[money.length];
        int[] notVisitFirst = new int[money.length];
        
        for (int i = 0; i < money.length; i++) {
            visitFirst[i] = money[i];
            notVisitFirst[i] = money[i];
        }
        // 두 가지 케이스 : 첫 집 방문 or 첫 집 방문 X
        // 첫 집 방문 시 두 번째 집은 방문할 수 없으므로 -1, 세 번째 집은 첫 번째 집을 털고 온 값 저장
        // 첫 집 방문 안할 시 첫 집에 -1
        visitFirst[1] = -1;
        visitFirst[2] += visitFirst[0];
        notVisitFirst[0] = -1;
        // 점화식 : 현재 인덱스로부터 두 칸 뒤 집과 세 칸 뒤 집 중 최댓값을 더하기
        for (int i = 3; i < money.length; i++){
            visitFirst[i] += Math.max(visitFirst[i - 2], visitFirst[i - 3]);
            notVisitFirst[i] += Math.max(notVisitFirst[i - 2], notVisitFirst[i - 3]);
        }
        // 첫 집 방문 시 마지막 집은 방문 불가하므로 마지막 집은 제외하고 최댓값 저장
        int visitFirstMax = Math.max(visitFirst[money.length - 2], visitFirst[money.length - 3]);
        // 첫 집 방문 안할 시 마지막 집을 포함해서 최대값 저장
        int notVisitFirstMax = Math.max(notVisitFirst[money.length - 1], notVisitFirst[money.length - 2]);
        
        return Math.max(visitFirstMax, notVisitFirstMax);
    }
}