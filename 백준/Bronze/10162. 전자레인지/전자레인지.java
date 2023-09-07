import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        long t = Integer.parseInt(br.readLine());
        int[] times = {3000, 60, 10};

        // 2. T초를 맞출 수 없을 때
        if (t % 10 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder answer = new StringBuilder();

        // 3. times 반복문 돌면서 answer에 결과 저장
        for (int time : times) {
            if (t >= time) {
                answer.append(t / time).append(" ");
                t %= time;
            } else {
                answer.append(0).append(" ");
            }
        }

        System.out.println(answer);
    }
}