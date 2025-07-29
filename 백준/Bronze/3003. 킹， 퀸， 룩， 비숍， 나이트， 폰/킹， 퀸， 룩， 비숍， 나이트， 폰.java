import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] black = {1, 1, 2, 2, 2, 8};
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < black.length; i++) {
            int white = Integer.parseInt(st.nextToken());
            out.append(black[i] - white).append(" ");
        }
        System.out.println(out);
    }
}