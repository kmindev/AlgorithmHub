import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int k = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                int num = stack.pop();
                answer -= num;
            } else {
                stack.push(input);
                answer += input;
            }
        }

        System.out.println(answer);

    }
}