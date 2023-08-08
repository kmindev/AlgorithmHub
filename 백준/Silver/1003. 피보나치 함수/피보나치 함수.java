import java.io.*;
import java.util.Arrays;

class Main {
    private static int[] zeroDP = new int[41];
    private static int[] oneDP = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        zeroDP[0] = 1;
        oneDP[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zeroDP[i] = zeroDP[i - 1] + zeroDP[i - 2];
            oneDP[i] = oneDP[i - 1] + oneDP[i - 2];
        }

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            result.append(zeroDP[n] + " " + oneDP[n] + "\n");
        }

        System.out.println(result);
    }
}