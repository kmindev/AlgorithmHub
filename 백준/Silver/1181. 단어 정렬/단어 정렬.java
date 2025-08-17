import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!words.contains(word)) {
                words.add(word);
            }
        }

        words.sort((o1, o2) -> {
            int x = o1.length() - o2.length();
            if (x == 0) {
                return o1.compareTo(o2);
            }
            return x;
        });

        for (int i = 0; i < words.size(); i++) {
            bw.write(words.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}