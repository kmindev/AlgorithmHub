import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX = Integer.MIN_VALUE;
    static int X = 0;
    static int Y = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > MAX) {
                    MAX = num;
                    X = i + 1;
                    Y = j + 1;
                }
            }
        }
        System.out.println(MAX);
        System.out.println(X + " " + Y);
    }
}