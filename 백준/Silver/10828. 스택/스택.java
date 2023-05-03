import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        Stack stack = new Stack(lines);

        for (int i = 0; i < lines; i++) {
            String line = reader.readLine();
            String[] s = line.split(" ");
            if (s[0].equals("push")) {
                stack.push(Integer.parseInt(s[1]));
            } else if (s[0].equals("pop")) {
                stack.pop();
            } else if (s[0].equals("size")) {
                stack.size();
            } else if (s[0].equals("empty")) {
                stack.isEmpty();
            } else if (s[0].equals("top")) {
                stack.top();
            }
        }
        reader.close();
    }
}

class Stack {
    int[] arr;
    int top;
    int size;

    Stack(int size) {
        arr = new int[size];
        top = -1;
        this.size = size;
    }

    void push(int n) {
        arr[++top] = n;
    }

    void pop() {
        if (top == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(arr[top--]);
    }

    void size() {
        System.out.println(top + 1);
    }

    void isEmpty() {
        if (top == -1) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    void top() {
        if (top == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(arr[top]);
    }
}
