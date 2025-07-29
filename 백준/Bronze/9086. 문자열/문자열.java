import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            String start = String.valueOf(s.charAt(0));
            String end = String.valueOf(s.charAt(s.length() - 1));
            System.out.println(start + end);
        }
    }
}