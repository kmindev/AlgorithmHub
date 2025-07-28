import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;

    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[42];
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num % 42] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}