import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        int result = findTemp(input[0].split("\\+"));

        for (int i = 1; i < input.length; i++) {
            String[] exp = input[i].split("\\+");
            result -= findTemp(exp);
        }

        System.out.println(result);
    }

    private static int findTemp(String[] exp) {
        int temp = 0;
        for (int j = 0; j < exp.length; j++) {
            temp += Integer.parseInt(exp[j]);
        }
        return temp;
    }
}