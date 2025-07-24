import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder out = new StringBuilder();
    static int L;
    static int C;
    static char[] alphabet;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        alphabet = new char[C];
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);
        dfs(new char[L], 0, 0, 0, 0);

        bw.write(out.toString());
        bw.flush();
    }

    static void dfs(char[] pass, int vCount, int cCount, int start, int depth) {
        if (depth == L) {
            if (vCount < 1 || cCount < 2) {
                return;
            }

            for (char ch : pass) {
                out.append(ch);
            }
            out.append("\n");
            return;
        }

        for (int i = start; i < C; i++) {
            pass[depth] = alphabet[i];
            if (isVowels(alphabet[i])) {
                dfs(pass, vCount + 1, cCount, i + 1, depth + 1);
            } else {
                dfs(pass, vCount, cCount + 1, i + 1, depth + 1);
            }
        }
    }

    private static boolean isVowels(char ch) {
        for (char vowel : vowels) {
            if (vowel == ch) {
                return true;
            }
        }
        return false;
    }
}