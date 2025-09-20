import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String word = br.readLine();
        String[] arr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = word.substring(i, word.length());
        }
        Arrays.sort(arr);

        for (String s : arr) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}