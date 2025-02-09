import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class main9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();
        int bombSize = bomb.length();
        for (int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i));
            if (stack.size() >= bombSize) {
                boolean flag = true;
                for (int j = 0; j < bombSize; j++) {
                    if (stack.get(stack.size() - bombSize + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bombSize; j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) sb.append(ch);
            System.out.println(sb);
        }

        
    }
}
