import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            Stack<String> stack = new Stack<>();
            boolean check = false;

            for (int j = 0; j < line.length(); j++) {
                String token = line.substring(j, j + 1);
                if (token.equals("(")) {
                    stack.push(token);
                } else if (token.equals(")")) {
                    if (stack.empty()) {
                        check = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.empty() || check) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}