import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2. 종료시간을 기준으로 정렬(종료시간이 같으며 시작시잔이 빠른순으로 정렬)
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        // 3. 종료시간이 다음 회의의 시작 시간보다 작거나 같다면 증가하고 종료시간 갱신
        int count = 0;
        int preEndTime = 0;

        for (int[] t : time) {
            if(preEndTime <= t[0]) {
                count++;
                preEndTime = t[1];
            }
        }

        System.out.println(count);

    }
}