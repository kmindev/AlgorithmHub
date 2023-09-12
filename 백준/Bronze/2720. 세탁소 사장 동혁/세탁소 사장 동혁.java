import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] coins = {25, 10, 5, 1};

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int c = Integer.parseInt(br.readLine());

            StringBuilder answer = new StringBuilder();


            for (int coin : coins) {
                if (c >= coin) {
                    answer.append(c / coin + " ");
                    c %= coin;
                } else {
                    answer.append(0 + " ");
                }
            }

            System.out.println(answer);
        }
    }
}

