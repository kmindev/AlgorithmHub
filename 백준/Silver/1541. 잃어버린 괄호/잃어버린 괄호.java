import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // -를 기준으로 식을 분할한다.
        String[] input = br.readLine().split("-");

        int result = findTemp(input[0].split("\\+")); // 첫번째 식의 결과를 result에 대입

        for (int i = 1; i < input.length; i++) {
            result -= findTemp(input[i].split("\\+")); // 하나의 식(exp)의 결과 temp를 구해서 result에서 뺀다.
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