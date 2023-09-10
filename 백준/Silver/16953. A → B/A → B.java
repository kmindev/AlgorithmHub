import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * b 를 a로 바꾸는 방식으로 해결
 * - b가 2로 나누어 떨어지면 b를 2로 나눈다.
 * - b의 마지막 자리가 1이면 1을 제거한다.
 * - 
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 1;
        while (b != a) {
            if (b < a) {
                System.out.println(-1);
                return;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b = b / 10;
            } else {
                System.out.println(-1);
                return;
            }

            answer++;
        }

        System.out.println(answer);
    }
}