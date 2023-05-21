import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            int t = sc.nextInt();

            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println("#" + t + " " + findResult(n, m, 1));
        }
    }

    private static int findResult(int n, int m, int res) {
        if (m > 0) {
            return findResult(n, m - 1, res *= n);
        }
        return res;
    }
}
