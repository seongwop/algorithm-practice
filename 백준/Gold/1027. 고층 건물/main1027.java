import java.io.*;
import java.util.*;
 
public class main1027 {
    static int[] arr;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st  = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, count(i));
        }
        
        System.out.println(answer);
    }
    
    // 왼쪽은 기울기 감소 오른쪽은 기울기 증가
    public static int count(int loc) {
        int cnt = 0;
        double lastSlope = 0;

        for (int i = loc - 1; i >= 1; i--) {
            double slope = (double) (arr[loc] - arr[i]) / (loc - i);
           
            if (i == loc - 1 || lastSlope > slope) {
                lastSlope = slope;
                cnt++;
            }
        }
        for (int i = loc + 1; i <= N; i++) {
            double slope = (double) (arr[i] - arr[loc]) / (i - loc);
            
            if (i == loc + 1 || lastSlope < slope) {
                lastSlope = slope;
                cnt++;
            }
        }
        return cnt;
    }
}