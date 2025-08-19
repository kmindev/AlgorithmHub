import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken()); // 분자
        int d1 = Integer.parseInt(st.nextToken()); // 분모
        st = new StringTokenizer(br.readLine());
        int m2 = Integer.parseInt(st.nextToken()); // 분자
        int d2 = Integer.parseInt(st.nextToken()); // 분모

        int d = d2 * d1;
        int m = (m1 * d2) + (m2 * d1);

        int div = 1;
        for (int i = d; i > 0; i--) {
            if (d % i == 0 & m % i == 0) {
                div = i;
                break;
            }
        }

        bw.write(m / div + " " + d / div);
        bw.flush();
        bw.close();
    }
}