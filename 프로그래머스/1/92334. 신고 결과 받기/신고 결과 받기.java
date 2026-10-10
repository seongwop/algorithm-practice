import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        int[] result = new int[id_list.length];
        int[] reportedNum = new int[id_list.length];
        int[][] reportList = new int[set.size()][2];
        int idx = 0;
        for (String s : set) {
            StringTokenizer st = new StringTokenizer(s);
            String reporter = st.nextToken();
            String reportee = st.nextToken();
            for (int j = 0; j < id_list.length; j++) {
                if (id_list[j].equals(reporter)) {
                    reportList[idx][0] = j;
                }
                if (id_list[j].equals(reportee)) {
                    reportList[idx][1] = j;
                }
            }
            idx++;
        }
        // List<String>[] reportList = new ArrayList[id_list.length];
        for (int[] i : reportList) {
            reportedNum[i[1]]++;
        }
        for (int[] i : reportList) {
            if (reportedNum[i[1]] >= k) {
                result[i[0]]++;
            }
        }
        
        return result;
    }
}