import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class main22866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N + 1];
        int[] cnt = new int[N + 1];
        int[] nearest = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            nearest[i] = -100000;
        }

        Stack<Integer> stack;
        // left 
        stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) stack.pop();
            cnt[i] += stack.size();
            if (cnt[i] > 0) nearest[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) stack.pop();
            int s = stack.size();
            cnt[i] += s;
            if (s > 0 && i - nearest[i] > stack.peek() - i) nearest[i] = stack.peek();
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(cnt[i]);
            if (cnt[i] > 0) sb.append(" ").append(nearest[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
