import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        for (int i = 0; i < w; i++) {
            // 2. 현재 위치에서 왼쪽에서 가장 높은 블록과 오른쪽에서 가장 높은 블록을 구한다.
            int leftMax = getLeftMax(arr, i);
            int rightMax = getRightMax(arr, i);

            // 3. 왼쪽, 오른쪽 블록 중 길이가 짧은 블록을 기준으로 현재의 블록과 비교하여 빗물의 양을 구한다.
            int min = Math.min(leftMax, rightMax);
            if (min > arr[i]) {
                result += (min - arr[i]);
            }
        }

        System.out.println(result);
    }

    private static int getLeftMax(int[] arr, int currentIndex) {
        int max = 0;
        for (int i = 0; i < currentIndex; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int getRightMax(int[] arr, int currentIndex) {
        int max = 0;
        for (int i = currentIndex + 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}