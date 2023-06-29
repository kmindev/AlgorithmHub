import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> inputs = new LinkedList<>();
        int min = Integer.MAX_VALUE; // 최소값
        int max = Integer.MIN_VALUE; // 최대값
        int sum = 0; // 합
        int freq = 0; // 최빈값
        int[] numCount = new int[8001]; // 양수 빈도수를 카운트 하기 위한 배열
        int maxCount = Integer.MIN_VALUE; // 최대 빈도수
        List<Integer> maxCountIndex = new LinkedList<>(); // 최대빈도수에 해당되는 index를 모두 추가하기 위한 list

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
            min = Math.min(input, min);
            max = Math.max(input, max);
            inputs.add(input);
            /**
             * 음수: 0 ~ 3999,       -4000 = 0 ,    -1 = 3999
             * 0 =  4000
             * 양수: 4001 ~ 8000    1 = 4001,   4000 = 8000
             */
            numCount[input + 4000]++; // 빈도를 구하기 위함.
        }

        Collections.sort(inputs);

        for (int i = 0; i < numCount.length; i++) {
            maxCount = Math.max(maxCount, numCount[i]); // 최대 빈도수를 구함.
        }

        for (int i = 0; i < numCount.length; i++) {
            if (maxCount == numCount[i]) {  // 빈도수가 같은 index 를 리스트에 저장
                maxCountIndex.add(i);
            }
        }

        Collections.sort(maxCountIndex);

        if (maxCountIndex.size() > 1) { // 최대 빈도수가 2개 이상일 때
            freq = maxCountIndex.get(1) - 4000; // 최대 빈도수 중 두번째로 작은 값.
        } else { // 최대 빈도수가 1개 일 때
            freq = maxCountIndex.get(0) - 4000; // 최대 빈도수
        }


        float avg = (float) sum / N;
        int avgRes = avg > 0 ? (int) (avg + 0.5) : (int) (avg - 0.5); // 평균이 양수와 음수 각각 반올림 처리

        System.out.println(avgRes);
        System.out.println(inputs.get(N / 2));
        System.out.println(freq);
        System.out.println(N == 1 ? 0 : (max - min)); // 입력받은 수가 1개이면 최대와 최소는 같음.
    }
}
