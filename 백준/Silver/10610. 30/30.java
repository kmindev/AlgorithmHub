import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 3의 배수와 10의 배수의 성질을 잘 파악하면 풀 수 있는 문제
// 각자리수의 합은 3의 배수이다.
// 10의 배수는 반드시 0을 포함해야 한다.

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            list.add(n.charAt(i) - '0');
            sum += list.get(i);
        }

        Collections.sort(list);

        StringBuilder answer = new StringBuilder();
        if (sum % 3 == 0 && list.get(0) == 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                answer.append(list.get(i));
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}