import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main24337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> al = new ArrayList<>();
        if (N < a + b - 1) {
            System.out.println(-1);
            return;
        }
        for (int i = 1; i <= a - 1; i++) al.add(i);
        al.add(Math.max(a, b));
        for (int i = b - 1; i >= 1; i--) al.add(i);
        if (a == 1) {
            while (al.size() < N) al.add(1, 1);
        } else {
            while (al.size() < N) al.add(0, 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : al) sb.append(i + " ");
        System.out.println(sb);
    }
}
