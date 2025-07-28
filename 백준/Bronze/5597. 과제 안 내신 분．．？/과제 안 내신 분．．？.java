import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[30];
        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num - 1] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                out.append(i + 1).append("\n");
            }
        }
        System.out.println(out.toString());
    }
}