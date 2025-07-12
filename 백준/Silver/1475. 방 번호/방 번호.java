import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받는다.
        int n = Integer.parseInt(br.readLine());

        // 2. 숫자가 몇 개 나왔는지 카운트 한다.(단, 6과 9는 하나의 숫자로 인식)
        int[] countArr = new int[10];
        while(n > 0) {
            int num = n % 10;
            if(num == 9) {
                num = 6;
            }
            countArr[num]++;
            n /= 10;
        }

        // 3. 카운트 배열의 최댓값을 구한다.
        countArr[6] = Math.round((float) countArr[6] / 2);
        int result = 0;
        for(int i = 0; i < countArr.length - 1; i++) {
            result = Math.max(result, countArr[i]);
        }

        System.out.println(result);
    }
}