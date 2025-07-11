import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // 월
        int y = Integer.parseInt(st.nextToken()); // 일

        String[] weeks = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day = 0;
        for (int i = 0; i < x; i++) {
            day += months[i];
        }

        day += y - 1;

        String result = weeks[day % 7];
        System.out.println(result);
    }
}