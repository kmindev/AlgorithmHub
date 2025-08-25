import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        int i = 0;
        int barCount = 0;
        int result = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);

            if (ch == '(' && i + 1 < input.length() && input.charAt(i + 1) == ')') { // 레이저인 경우
                i += 2;
                result += barCount;
                continue;
            }

            if (ch == '(') {
                barCount++;
            } else if (ch == ')') {
                barCount--;
                result++;
            }
            i++;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}