import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int a = 0;
        int cnt = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a') a++;
        }
        int left = 0, right = a - 1;
        a = 0;
        for (int i = 0; i <= right; i++) {
            if (arr[i] == 'a') a++;
        }
        cnt = right + 1 - a;
        answer = Math.min(answer, cnt);

        right++;
        for (int i = 0; i < arr.length; i++) {
            if (right > arr.length - 1) right = right - arr.length; 
            if (arr[left++] == 'b') cnt--;
            if (arr[right++] == 'b') cnt++;
            answer = Math.min(answer, cnt);
        }
        System.out.println(answer);
    }
    
}
