import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 0;
        int yearE = 0;
        int yearS = 0;
        int yearM = 0;

        while (true) {
            if (yearE == E && yearS == S && yearM == M) {
                break;
            }

            year++;
            yearE++;
            yearS++;
            yearM++;

            if (yearE > 15) {
                yearE = 1;
            }

            if (yearS > 28) {
                yearS = 1;
            }

            if (yearM > 19) {
                yearM = 1;
            }
        }
        System.out.println(year);
    }
}