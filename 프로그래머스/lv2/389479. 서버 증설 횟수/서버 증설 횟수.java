import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] expiredAt = new int[24 + k];
        
        int currentServers = 0;
        
        for (int i = 0; i < players.length; i++) {
            currentServers -= expiredAt[i];
            if (players[i] > currentServers * m) {
                int addedServers = (players[i] - currentServers * m) / m;
                currentServers += addedServers;
                expiredAt[i + k] += addedServers;
                answer += addedServers;
            }
        }
        
        // // 모든 서버에 대한 (서버 수, 남은 시간)을 관리하면서
        // // 총 서버 수보다 많아질 경우 새 키-값 추가, 시간이 지나면서 모든 값 - 1
        // // 남은 시간이 0이 되면 삭제
        // List<int[]> serverList = new ArrayList<>();
        // for (int i : players) {
        //     int currentCapacity = currentServer(serverList) * m;
        //     if (i > currentCapacity) {
        //         serverList.add(new int[]{(i - currentCapacity) / m, k});
        //         answer += (i - currentCapacity) / m;
        //     }
        //     reduceServerTime(serverList);
        // }
        return answer;
    }
    
//     int currentServer(List<int[]> serverList) {
//         int num = 0;
//         for (int[] list : serverList) {
//             num += list[0];
//         }
//         return num;
//     }
    
//     void reduceServerTime(List<int[]> serverList) {
//         for (int i = 0; i < serverList.size(); i++) {
//             serverList.get(i)[1] -= 1;
//             if (serverList.get(i)[1] == 0) {
//                 serverList.remove(i);
//                 i--;
//             }
//         }
//     }
}