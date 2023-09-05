import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int change = 1000 - Integer.parseInt(br.readLine());
        int coins[] = {500, 100, 50, 10, 5, 1};
        int count = 0;

        // 2. coins[] 반복문 돌면서 count 갱신
        for (int coin : coins) {
            if (change >= coin) {
                count += (change / coin);
                change %= coin;
            }
        }

        System.out.println(count);
    }
}