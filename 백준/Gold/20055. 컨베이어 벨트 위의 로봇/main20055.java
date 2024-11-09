import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class main20055 {

    static LinkedList<Belt> conveyor = new LinkedList<>();
    static int N, K, zeros, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            conveyor.add(new Belt(Integer.parseInt(st.nextToken())));
        }
        
        while (zeros < K) {
            cnt++;
            moveConveyor();
            moveRobot();
        }

        System.out.println(cnt);
    }

    static void moveConveyor() {
        conveyor.addFirst(conveyor.removeLast());    
        if(conveyor.get(N - 1).robot) conveyor.get(N - 1).robot = false;   
    }

    static void moveRobot() {
        for (int i = N - 2; i > 0; i--) {
            if (conveyor.get(i).robot == true) {
                if (i == N - 2 && conveyor.get(i + 1).durability > 0) {
                    conveyor.get(i).robot = false;
                    if (--conveyor.get(i + 1).durability <= 0) zeros++;
                } else if (conveyor.get(i + 1).robot == false && conveyor.get(i + 1).durability > 0) {
                    conveyor.get(i).robot = false;
                    conveyor.get(i + 1).putRobot();
                    if (conveyor.get(i + 1).durability <= 0) zeros++;
                }
            }
        }
        if (conveyor.get(0).durability > 0) {
            conveyor.get(0).putRobot();
            if (conveyor.get(0).durability <= 0) zeros++;
        }
    }

    static class Belt {
        int durability;
        boolean robot;

        public Belt(int durability) {
            this.durability = durability;
        }

        public void putRobot() {
            robot = true;
            durability--;
        }
    }
}