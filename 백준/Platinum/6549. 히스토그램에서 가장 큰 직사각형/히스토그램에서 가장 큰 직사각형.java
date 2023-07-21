import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());

            if (size == 0) break;

            long[] histogram = new long[size];
            Stack<Integer> stack = new Stack<>();

            long height = 0;
            int index = 0;
            long max = 0;

            for (int i = 0; i < size; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            // 스택에는 인덱스를 담고 다음 높이가 작거나 같을 경우 쌓아둔 스택을 하나씩 빼면서 최대 넓이를 계산함
            for (int i = 0; i < size; i++) {
                // 스택에 들어있는 인덱스에 해당하는 높이가 현재 인덱스의 높이보다 크거나 같을 동안 스택에서 뺀다
                while (!stack.isEmpty() && histogram[i] <= histogram[stack.peek()]) {
                    index = stack.pop();
                    height = histogram[index];
                    if (stack.isEmpty()) {
                        max = Math.max(max, height * (i));
                        break;
                    }
                    max = Math.max(max, height * (i - 1 - stack.peek()));
                }
                stack.push(i);
            }
            // 스택에 남아있는 값들 처리
            while (!stack.isEmpty()) {
                index = stack.pop();
                height = histogram[index];
                if (stack.isEmpty()) {
                    max = Math.max(max, height * size);
                    break;
                }
                max = Math.max(max, height * (size - 1 - stack.peek()));

            }
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }
}