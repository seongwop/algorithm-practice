import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int left = 0, right = N - 1;
            while (true) {
                if (i == left) left++;
                else if (i == right) right--;

                if (left >= right) break;
                
                if (arr[left] + arr[right] < arr[i]) left++;
                else if (arr[left] + arr[right] > arr[i]) right--;
                else {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
