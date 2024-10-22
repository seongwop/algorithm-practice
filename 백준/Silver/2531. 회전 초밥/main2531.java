import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main2531 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] arr = new int[N + k];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N; i < N + k; i++) {
            arr[i] = arr[i - N];
        }

        int[] cur = new int[d + 1];
        int left = 0, right = k;
        int cnt = 0;

        cur[c]++;
        cnt++;
        for (int i = 0; i < k; i++) {
            cur[arr[i]]++;    
            if (cur[arr[i]] > 1) continue;
            cnt++;
        }
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < N; i++) {
            if (cur[arr[left]] > 1) {
                cur[arr[left++]]--;
            } else {
                cur[arr[left++]]--;
                cnt--;
            }

            if (cur[arr[right]] > 0) {
                cur[arr[right++]]++;
            } else {
                cur[arr[right++]]++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
