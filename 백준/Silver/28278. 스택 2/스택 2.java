import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (command == 2) {
                try {
                    int num = stack.pop();
                    bw.write(num + "\n");
                } catch (EmptyStackException e) {
                    bw.write("-1\n");
                }
            } else if (command == 3) {
                bw.write(stack.size() + "\n");
            } else if (command == 4) {
                if (stack.empty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (command == 5) {
                if (stack.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}