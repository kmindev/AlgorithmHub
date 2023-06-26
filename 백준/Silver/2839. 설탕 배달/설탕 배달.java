import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        while (true) {
            if (N % 5 == 0) { // 5의 배수인 경우
                result += (N / 5);
                N %= 5;
            }

            if (N < 3) break; // 더이상 나눌 수 없는 경우

            result++;
            N -= 3;
        }
        if(N == 0) System.out.println(result);
        else System.out.println(-1);
    }
}
