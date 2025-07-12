import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] switches = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int studentsCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentsCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (sex == 1) { // 남자
                processMan(switches, number);
            } else { // 여자
                processWoman(switches, number);
            }
        }

        for (int i = 0; i < switches.length; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void processMan(int[] switches, int number) {
        for (int i = number; i <= switches.length; i += number) {
            change(switches, i - 1);
        }
    }

    private static void processWoman(int[] switches, int number) {
        int count = 1;
        change(switches, number - 1);

        while (number - count > 0 && number + count <= switches.length && switches[number + count - 1] == switches[number - count - 1]) {
            change(switches, number + count - 1);
            change(switches, number - count - 1);
            count++;
        }
    }

    private static void change(int[] switches, int index) {
        if (switches[index] == 0) {
            switches[index] = 1;
        } else {
            switches[index] = 0;
        }
    }
}