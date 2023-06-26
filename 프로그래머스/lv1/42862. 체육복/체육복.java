import java.util.Arrays;

public class Solution {
    /**
     * n: 전체학생수
     * lost: 체육복을 도난당한 학생들의 번호
     * reverse: 여벌 체육복을 가져온 학생들의 번호
     */
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 챙겨온 학생중에 체육복을 잃어버린 학생은 빌려줄 수 없음.
        for (int i = 0; i < lost.length; i++) {
            int lostNum = lost[i];
            for (int j = 0; j < reserve.length; j++) {
                if (lostNum == reserve[j]) {
                    answer++;
                    reserve[j] = -10;
                    lost[i] = -1;
                    break;
                }
            }
        }

        // 여벌 챙겨온 학생이 잃어버린 학생을 빌려줌.
        for (int i = 0; i < lost.length; i++) {
            int lostNum = lost[i];
            for (int j = 0; j < reserve.length; j++) {
                if (lostNum + 1 == reserve[j] || lostNum - 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -10;
                    break;
                }
            }
        }

        return answer;
    }
}