import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int credit_sum = 0;
    static double result = 0f;
    static Map<String, Float> GRADE = new HashMap<>();

    static {
        GRADE.put("A+", 4.5f);
        GRADE.put("A0", 4.0f);
        GRADE.put("B+", 3.5f);
        GRADE.put("B0", 3.0f);
        GRADE.put("C+", 2.5f);
        GRADE.put("C0", 2.0f);
        GRADE.put("D+", 1.5f);
        GRADE.put("D0", 1.0f);
        GRADE.put("F", 0.0f);
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int credit = (int) Float.parseFloat(st.nextToken());
            String rank = st.nextToken();

            if (rank.equals("P")) {
                continue;
            }

            credit_sum += credit;
            float score = score(credit, rank);
            result += score;
        }

        System.out.println(result / credit_sum);
    }

    private static float score(int credit, String rank) {
        return credit * GRADE.get(rank);
    }
}