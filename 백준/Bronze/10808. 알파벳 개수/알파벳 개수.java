import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            count[index]++;
        }

        for (int c : count) {
            bw.write(c + " ");
        }

        bw.flush();
        bw.close();
    }
}