import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main17615 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int red = 0, blue = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') red++;
            else if (arr[i] == 'B') blue++; 
        }
        int left_red = 0, right_red = 0, left_blue = 0, right_blue = 0;
        int left = 0, right = 0;  
        int cnt = 0;

        if (red == N || blue == N) System.out.println(0);
        else {
            for (int i = 0; i < N; i++) {
                if (arr[i] == 'R') cnt++;
                else break;
            }
            left_red = red - cnt;
            cnt = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == 'B') cnt++;
                else break;
            }
            left_blue = blue - cnt;
            cnt = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] == 'R') cnt++;
                else break;
            }
            right_red = red - cnt;
            cnt = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] == 'B') cnt++;
                else break;
            }
            right_blue = blue - cnt;

            left = Math.min(left_red, left_blue);
            right = Math.min(right_red, right_blue);

            System.out.println(Math.min(right, left));
        }
    }    
}
