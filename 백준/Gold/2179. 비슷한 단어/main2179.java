import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class main2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        int maxCnt = 0, first = 0, second = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!list.contains(str)) list.add(str);
        }

        for (int i = 0; i < list.size(); i++) {
            String str1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int cnt = 0;
                String str2 = list.get(j);
                int length = Math.min(str1.length(), str2.length());
                for (int k = 0; k < length; k++) {
                    if (str1.charAt(k) == str2.charAt(k)) cnt++;
                    else break;
                }
                if (cnt > maxCnt) {
                    first = i;
                    second = j;
                    maxCnt = cnt;
                }
            }
        }
        System.out.println(list.get(first));
        System.out.println(list.get(second));
    }
}