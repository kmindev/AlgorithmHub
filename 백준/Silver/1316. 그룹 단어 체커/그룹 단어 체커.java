import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                result++;
            }
        }
        System.out.println(result);
    }

    static boolean isGroupWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int lastIndex = i + 1;
            for (; lastIndex < word.length(); lastIndex++) {
                if (ch != word.charAt(lastIndex)) {
                    break;
                }
            }

            for (int j = lastIndex + 1; j < word.length(); j++) {
                if (ch == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}