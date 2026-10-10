import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
// import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        // 나를 신고한 유저들을 Set에 담아서 중복 제거
        // Set의 원소 수가 신고 횟수를 넘을 때 신고자들 +1
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
        }
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }
        for (String s : report) {
            StringTokenizer st = new StringTokenizer(s);
            String reporter = st.nextToken();
            String reportee = st.nextToken();
            Set<String> set = reportMap.get(reportee);
            set.add(reporter);
        }
        
        for (String id : id_list) {
            Set<String> set = reportMap.get(id);
            if (set.size() >= k) {
                for (String reporter : set) {
                    int reporterIdx = idIndexMap.get(reporter);
                    result[reporterIdx]++;
                }
            }
        }
        
        return result;
        
        
// 시간 복잡도 O(N x M)       
//         Set<String> set = new HashSet<>(Arrays.asList(report));
        
//         int[] result = new int[id_list.length];
//         int[] reportedNum = new int[id_list.length];
//         int[][] reportList = new int[set.size()][2];
//         int idx = 0;
//         for (String s : set) {
//             StringTokenizer st = new StringTokenizer(s);
//             String reporter = st.nextToken();
//             String reportee = st.nextToken();
//             for (int j = 0; j < id_list.length; j++) {
//                 if (id_list[j].equals(reporter)) {
//                     reportList[idx][0] = j;
//                 }
//                 if (id_list[j].equals(reportee)) {
//                     reportList[idx][1] = j;
//                 }
//             }
//             idx++;
//         }
//         // List<String>[] reportList = new ArrayList[id_list.length];
//         for (int[] i : reportList) {
//             reportedNum[i[1]]++;
//         }
//         for (int[] i : reportList) {
//             if (reportedNum[i[1]] >= k) {
//                 result[i[0]]++;
//             }
//         }
        
//         return result;
    }
}