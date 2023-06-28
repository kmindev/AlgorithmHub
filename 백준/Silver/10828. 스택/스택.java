import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String token = st.nextToken();

            if (token.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (token.equals("pop")) {
                int result = stack.empty() ? -1 : stack.pop();
                System.out.println(result);
            } else if (token.equals("size")) {
                System.out.println(stack.size());
            } else if (token.equals("empty")) {
                int result = stack.empty() ?  1 : 0;
                System.out.println(result);
            } else if (token.equals("top")) {
                int result = stack.empty() ? -1 : stack.peek();
                System.out.println(result);
            }
        }

    }
}