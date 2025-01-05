import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main2138 {
    static boolean[] bl;
    static boolean[] bl2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String bulb = br.readLine();
        String bulb2 = br.readLine();
        bl = new boolean[N];
        bl2 = new boolean[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (bulb.charAt(i) == '1') bl[i] = true;
            if (bulb2.charAt(i) == '1') bl2[i] = true;
        }
        // 처음에 안키는 경우
        for (int i = 1; i < N; i++) {
            if (bl[i - 1] != bl2[i - 1]) {
                cnt++;
                swap(i - 1);
                swap(i);
                if (i != N - 1) swap(i + 1);
            }
        }
        if (bl[N - 1] == bl2[N - 1]) {
            System.out.println(cnt);
            return;
        }
        
        // 처음에 키는 경우
        bl = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (bulb.charAt(i) == '1') bl[i] = true;
        }
        cnt = 1;
        swap(0);
        swap(1);
        for (int i = 1; i < N; i++) {
            if (bl[i - 1] != bl2[i - 1]) {
                cnt++;
                swap(i - 1);
                swap(i);
                if (i != N - 1) swap(i + 1);
            }
        }
        if (bl[N - 1] == bl2[N - 1]) {
            System.out.println(cnt);
            return;
        }
        System.out.println(-1);
    }

    static void swap(int idx) {
        if (bl[idx] == true) bl[idx] = false;
        else bl[idx] = true;
    }
    
}
