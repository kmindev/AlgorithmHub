import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for(int i = 0; i < arr.length; i++) {
            int result = -1;
            for(int j = 0; j < s.length(); j++) {
                String a = s.substring(j, j + 1);
                if(arr[i].equals(a)) {
                    result = j;
                    break;
                }
            }
            System.out.print(result + " ");
        }
    }
}
