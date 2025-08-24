import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (ch != '(' && ch != '[' && ch != ')' && ch != ']') {
                    continue;
                }

                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                } else {
                    stack.push(ch);
                }
            }

            if (isBalanced && stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }

        }
        bw.flush();
        bw.close();
    }
}