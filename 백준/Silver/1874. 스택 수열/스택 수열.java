import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        // 1. 입력 받기
        int n = Integer.parseInt(br.readLine());

        /**
         * 조건
         * 1. 넣어야할 값이 입력값보다 작으면 같아질 때까지 push
         * 2. 넣어야할 값이 입력값보다 크거나 같으면 pop하고 pop 한 값이 다르면 No 출력
         */

        int curNum = 0;
        StringBuilder answer = new StringBuilder();

        while (n-- > 0) {
            int value = Integer.parseInt(br.readLine());

            // 현재값 입력값보다 작으면 같아질 때까지 push
            if (curNum < value) {
                for (int i = curNum + 1; i <= value; i++) {
                    stack.push(i);
                    answer.append("+").append("\n");
                }
                curNum = value;
            } else if(stack.peek() != value) { // 스택의 마지막 값이 현재값이랑 다르면 만들 수 없는 수열임.
                System.out.println("NO");
                return;
            }

            stack.pop();
            answer.append("-").append("\n");
        }

        System.out.println(answer);
    }
}