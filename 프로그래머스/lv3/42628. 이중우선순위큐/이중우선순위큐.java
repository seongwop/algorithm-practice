import java.util.TreeMap;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String ops : operations) {
            StringTokenizer st = new StringTokenizer(ops);
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            if (op == 'I') {
                // 값에 해당 키의 개수 삽입
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if (op == 'D') {
                if (map.isEmpty()) continue;
                int key = (num == 1) ? map.lastKey() : map.firstKey();
                if (map.put(key, map.get(key) - 1) == 1) {
                    map.remove(key);
                }
            }
        }
        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{map.lastKey(), map.firstKey()};
    }
}