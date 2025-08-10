import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] parts = pattern.split("\\*");
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (isMatch(parts, input)) {
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean isMatch(String[] parts, String input) {
        String start = parts[0];
        String end = parts[1];
        if (input.length() < start.length() + end.length()) {
            return false;
        }
        return input.startsWith(start) && input.endsWith(end);
    }
}