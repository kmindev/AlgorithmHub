import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] arr = new int[10];
        String N = br.readLine();
        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            arr[num]++;
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                bw.write(i + "");
            }
        }

        bw.flush();
        bw.close();
    }
}