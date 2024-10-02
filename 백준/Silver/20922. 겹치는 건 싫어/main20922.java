import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main20922 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] cnt = new int[100001];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, answer = 0;

        while (left <= right) {
            if (cnt[arr[right]] == K) {
                cnt[arr[left]]--;
                left++;
            } else if (right <= N - 1 && cnt[arr[right]] < K) {
                cnt[arr[right]]++;
                right++;
            }
            answer = Math.max(answer, right - left);
            if (right == N) break;
        } 
        System.out.println(answer);
    }
}