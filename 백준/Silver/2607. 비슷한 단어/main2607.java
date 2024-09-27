import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main2607 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(bf.readLine());
        String word = bf.readLine();
        char[] chars = word.toCharArray();

        for (int i = 0; i < N - 1; i++) {
            int cnt = 0;
            char[] chars_2 = bf.readLine().toCharArray();
            if (Math.abs(chars.length - chars_2.length) > 1) 
                continue;

            ArrayList<Character> al = new ArrayList<>();
            for (char c : chars_2) al.add(c);
            
            for (char ch : chars) {
                for (int j = 0; j < al.size(); j++) {
                    if (ch == al.get(j)) {
                        cnt++;
                        al.remove(j);
                        break;
                    }
                }
            }

            if (chars.length == cnt) answer++;
            else if (chars.length - cnt == 1 && chars.length >= chars_2.length) answer++;
        }
        System.out.println(answer);
    }
}
