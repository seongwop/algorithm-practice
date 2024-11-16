import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class main2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        int num = 0;
        stack.add(new int[]{1, Integer.parseInt(st.nextToken())});
        sb.append("0 ");
        for (int i = 2; i <= N; i++) {
            num = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < num) {
                stack.pop();
            } 
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.add(new int[]{i, num});
            } else {
                sb.append(stack.peek()[0] + " ");
                stack.add(new int[]{i, num});
            }
        }
        System.out.println(sb);
    }
}
