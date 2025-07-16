import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 모든 조합을 구한다.
        int[] out = new int[3];
        List<List<Integer>> list = new ArrayList<>();
        comb(list, out, 0, 0);

        // 2. 모든 조합에서 M보다 작으면서 최대값을 구한다.
        int result = getResult(list);
        System.out.println(result);
    }

    private static int getResult(List<List<Integer>> list) {
        int max = Integer.MIN_VALUE;
        for (List<Integer> tempList : list) {
            int sum = 0;
            for (int num : tempList) {
                sum += num;
            }
            if (sum <= M) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    static void comb(List<List<Integer>> list, int[] out, int start, int depth) {
        if (depth == out.length) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : out) {
                tempList.add(num);
            }
            list.add(tempList);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            comb(list, out, i + 1, depth + 1);
        }
    }
}