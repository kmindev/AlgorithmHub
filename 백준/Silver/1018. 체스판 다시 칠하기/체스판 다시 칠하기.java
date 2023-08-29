import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // W: true, B: false
        boolean[][] board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) == 'W';
            }
        }

        int minResult = Integer.MAX_VALUE;

        // 2. 8 x 8 보드로 나누기
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                // 3. 다시 칠해야하는 개수를 구한다.
                int getCount = getSolution(i, j, board);

                // 4. 최소 개수를 구한다.
                minResult = Math.min(minResult, getCount);
            }
        }

        System.out.println(minResult);
    }

    private static int getSolution(int low, int col, boolean[][] board) {
        boolean[][] orgBoard = {
                {true, false, true, false, true, false, true, false,},
                {false, true, false, true, false, true, false, true,}
        };

        int count = 0;

        for (int i = low; i < 8 + low; i++) {
            for (int j = col; j < 8 + col; j++) {
                if (orgBoard[i % 2][j % 8] != board[i][j]) {
                    count++;
                }
            }
        }

        return Math.min(count, 64 - count);
    }
}

