import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
        }

        boolean isNice = solution(numbers);
        if (isNice) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }

        bw.flush();
        bw.close();
    }

    private static boolean solution(int[] numbers) {
        Stack<Integer> tempLine = new Stack<>();
        int currentNum = 1;
        for (int number : numbers) {
            if (currentNum == number) {
                currentNum++;
                while (!tempLine.isEmpty()) {
                    int tempNum = tempLine.peek();
                    if (tempNum == currentNum) {
                        tempLine.pop();
                        currentNum++;
                    } else {
                        break;
                    }
                }
            } else {
                tempLine.push(number);
            }
        }
        return tempLine.isEmpty();
    }
}