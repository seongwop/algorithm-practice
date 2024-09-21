import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
import java.lang.Math;


public class main2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] col = new int[1001];
        int minL = Integer.MAX_VALUE;
        int maxL = Integer.MIN_VALUE;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            minL = Math.min(minL, l);
            maxL = Math.max(maxL, l);
            col[l] = h;
        }

        Stack<Integer> height = new Stack<>();
    
        int temp = col[minL];
        for (int i = minL; i <= maxL; i++) {
            if (temp > col[i]) height.add(i);
            else {
                while (!height.isEmpty()) {
                    col[height.pop()] = temp;
                }
                temp = col[i];
            }
        }
        height.clear();

        temp = col[maxL];
        for (int i = maxL; i >= minL; i--) {
            if (temp > col[i]) height.add(i);
            else {
                while (!height.isEmpty()) {
                    col[height.pop()] = temp;
                }
                temp = col[i];
            }
        }

        for (int i = minL; i <= maxL; i++) {
            answer += col[i];
        }
        System.out.println(answer);
        
    }
}