import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = N - 1, al = 0, ar = 0, min = Integer.MAX_VALUE;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                al = left;
                ar = right;
            }
            if (sum < 0) left++;
            else if (sum > 0) right--;
            else {
                al = left;
                ar = right;
                break;
            }
        }
        System.out.println(arr[al] + " " + arr[ar]);
    }
}
