import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[100][100];
        int result = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int j = w; j < w + 10; j++) {
                for (int k = h; k < h + 10; k++) {
                    if (!arr[j][k]) {
                        arr[j][k] = true;
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}