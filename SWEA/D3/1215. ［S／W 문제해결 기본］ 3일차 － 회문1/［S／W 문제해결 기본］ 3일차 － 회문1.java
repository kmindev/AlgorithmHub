import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            int len = sc.nextInt();
            char[][] arr = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String input = sc.next();
                for (int j = 0; j < input.length(); j++) {
                    arr[i][j] = input.charAt(j);
                }
            }
            int result = 0;

            // 가로 회문 확인
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - len; j++) {
                    boolean check = true;
                    for (int x = 0; x < len / 2; x++) {
                        if (arr[i][j + x] != arr[i][j + len - 1 - x]) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        result++;
                    }
                }
            }

            // 세로 회문 확인
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - len; j++) {
                    boolean check = true;
                    for (int x = 0; x < len / 2; x++) {
                        if (arr[j + x][i] != arr[j + len - 1 - x][i]) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        result++;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
