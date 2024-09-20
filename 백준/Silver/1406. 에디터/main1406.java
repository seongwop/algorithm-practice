import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class main1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = bf.readLine();
        int N = Integer.parseInt(bf.readLine());

        char[] chars = str.toCharArray();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : chars) left.add(c);
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            String first = st.nextToken();
            if (first.equals("L") && !left.isEmpty()) {
                right.add(left.pop());
            } else if (first.equals("D") && !right.isEmpty()) {
                left.add(right.pop());
            } else if (first.equals("P")) {
                left.add(st.nextToken().charAt(0));
            } else if (first.equals("B") && !left.isEmpty()) {
                left.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : left) sb.append(c);
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}