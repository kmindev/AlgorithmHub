import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            names.add(name);
        }
        int result = 0;
        if (game.equals("Y")) {
            result = names.size();
        } else if (game.equals("F")) {
            result = names.size() / 2;
        } else if (game.equals("O")) {
            result = names.size() / 3;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
