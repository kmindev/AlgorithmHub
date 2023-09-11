import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int t = Integer.parseInt(br.readLine()); // 전체 테스트 케이스

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[][] applicants = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            // 2. 서류 성적을 기준으로 정렬

            Arrays.sort(applicants, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            // 3. 서류 1등부터 순차적으로 돌면서 면접 점수가 curScore 보다 작으면 curScore하고 answer 증가

            int curScore = applicants[0][1]; // 서류 점수 1등의 면접 점수
            int answer = 1; // 서류 점수 1등은 무조건 포함

            for(int[] applicant : applicants) {
                if(curScore > applicant[1]) {
                    answer++;
                    curScore = applicant[1];
                }
            }

            System.out.println(answer);
        }
    }
}

