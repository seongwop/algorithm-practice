import java.util.*;
import java.io.*;

public class main1283 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[300];
        int N = Integer.parseInt(br.readLine());
        int temp = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                if (temp == 0 && alphabet[Character.toLowerCase(word.charAt(0))] == 0) {
                    char[] arr = word.toCharArray();
                    for (int j = 0; j < arr.length; j++) {
                        if (j == 0) {
                            sb.append("[" + arr[j] + "]");
                            alphabet[Character.toLowerCase(arr[j])] = 1;
                        }
                        else sb.append(arr[j]);
                    }
                    while (st.hasMoreTokens()) {
                        sb.append(" " + st.nextToken());
                    }
                    temp = 1;
                    System.out.println(sb);
                    break;
                } else {
                    sb.append(word + " ");
                }
            }
            if (temp == 0) {
                sb.setLength(0);
                st = new StringTokenizer(str);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    char[] arr = word.toCharArray();
                    int tmp = 0;
                    for (int j = 1; j < arr.length; j++) {
                        if (alphabet[Character.toLowerCase(arr[j])] == 0) {
                            tmp = j;
                            break;
                        }
                    }
                    if (tmp != 0) {
                        for (int j = 0; j < arr.length; j++) {
                            if (j == tmp) {
                                sb.append("[" + arr[j] + "]");
                                alphabet[Character.toLowerCase(arr[j])] = 1;
                            } else {
                                sb.append(arr[j]);
                            }
                        }
                        while (st.hasMoreTokens()) {
                            sb.append(" " + st.nextToken());
                        }
                        break;
                    } else {
                        sb.append(word + " ");
                    }
                }
                System.out.println(sb);
            }
            sb.setLength(0);
            temp = 0;
        }
    }
}
