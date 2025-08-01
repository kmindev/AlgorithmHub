import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] arr = new String[5];

    public static void main(String[] args) throws IOException {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i >= arr[j].length()) {
                    continue;
                }
                out.append(arr[j].charAt(i));
            }
        }
        System.out.println(out);
    }
}