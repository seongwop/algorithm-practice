import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[11];
        int num = 0;
        
        for (int i = 1; i <= N; i++) {
            num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                for (int j = 1; j <= N; j++) {
                    if (arr[j] == 0) {
                        arr[j] = i;
                        break;
                    }
                } 
            } else {
                int index = 1;
                int n = 0;
                while (num != n) {
                    if (arr[index++] == 0) n++;
                }
                while (arr[index] != 0) {
                    index++;
                }
                arr[index] = i;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);

    }
}