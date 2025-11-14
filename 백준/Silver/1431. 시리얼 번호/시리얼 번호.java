import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<String> guitars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            guitars.add(br.readLine());
        }

        Collections.sort(guitars, (A, B) -> {
            if (A.length() != B.length()) {
                return A.length() - B.length();
            }
            int sumA = 0;
            int sumB = 0;
            
            for (int i = 0; i < A.length(); i++) {
                char a = A.charAt(i);
                char b = B.charAt(i);
                
                if (Character.isDigit(a)) {
                    sumA += Character.getNumericValue(a);
                }
                
                if (Character.isDigit(b)) {
                    sumB += Character.getNumericValue(b);
                }
            }
            if (sumA != sumB) {
                return sumA - sumB;
            }
            return A.compareTo(B);
        });

        for (String guitar : guitars) {
            bw.write(guitar + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}