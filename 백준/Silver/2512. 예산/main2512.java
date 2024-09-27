import java.io.*;
import java.util.*;

public class main2512 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int total = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        int left = 0, right = -1;
        int mid = 0;
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            right = Math.max(right, num);
        }

        while (left <= right) {
            int budget = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                if (nums[i] < mid) budget += nums[i];
                else budget += mid;
            }
            if (budget <= total) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(right);
    }
}