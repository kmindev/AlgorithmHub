import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = "1 2 3 4 5 6 7 8";
        String b = "8 7 6 5 4 3 2 1";
        String line = br.readLine();
        
        if(a.equals(line)) {
            System.out.print("ascending");
        } else if(b.equals(line)) {
            System.out.print("descending");
        } else {
            System.out.print("mixed");
        }
    }
}
