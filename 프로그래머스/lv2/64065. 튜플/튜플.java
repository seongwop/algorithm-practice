import java.util.StringTokenizer;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("\\},\\{");
        Set<Integer> set = new LinkedHashSet<>();
        List<List<Integer>> entireList = new ArrayList<>();
        for (String str : arr) {
            StringTokenizer st2 = new StringTokenizer(str, ",");
            List<Integer> list = new ArrayList<>();
            while (st2.hasMoreTokens()) {
                list.add(Integer.parseInt(st2.nextToken()));
            }
            entireList.add(list);
        }
        Collections.sort(entireList, (a, b) -> a.size() - b.size());
        for (List<Integer> list : entireList) {
            for (int num : list) {
                set.add(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}