import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long count = 0;
        long sum = 0;
        while (true) {
            if (sum > s) break;
            count++;
            sum += count;

        }

        System.out.println(count - 1);
    }
}