import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String S;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        System.out.println(S.length());
    }
}