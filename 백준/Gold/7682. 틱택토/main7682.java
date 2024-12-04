import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main7682 {
    static char[][] arr = new char[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        while (!str.equals("end")) {    
            int X = 0, O = 0, dot = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char temp = str.charAt(i * 3 + j);
                    if (temp == 'X') X++;
                    else if (temp == 'O') O++;
                    else dot++;
                    arr[i][j] = temp; 
                }
            }
            boolean check_O = check('O'), check_X = check('X');
            if (X - O > 1 || X - O < 0) sb.append("invalid\n");
            else if (check_O && check_X) sb.append("invalid\n");
            else if (check_O && O != X) sb.append("invalid\n");
            else if (check_X && X - 1 != O) sb.append("invalid\n");
            else if (!check_X && !check_O && dot != 0) sb.append("invalid\n");
            else sb.append("valid\n");

            str = br.readLine();
        }
        System.out.println(sb);
    }

    static boolean check(char ch) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == ch) cnt++;
            }
            if (cnt == 3) return true;
        }

        for (int i = 0; i < 3; i++) {
            cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (arr[j][i] == ch) cnt++;
            }
            if (cnt == 3) return true;
        }

        cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i][i] == ch) cnt++;
        }
        if (cnt == 3) return true;

        cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i][2 - i] == ch) cnt++;
        }
        if (cnt == 3) return true;
        return false;
    }
}
