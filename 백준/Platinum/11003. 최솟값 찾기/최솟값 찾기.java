import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        // Deque를 이용하여 index를 벗어난 경우는 앞에서 전부 제거, 들어올 숫자보다 큰 값들이 존재한다면 뒤에서 전부 제거
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekFirst()[0] < i - L + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast()[1] >= number) {
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, number});

            if (!deque.isEmpty()) {
                sb.append(deque.peekFirst()[1]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}