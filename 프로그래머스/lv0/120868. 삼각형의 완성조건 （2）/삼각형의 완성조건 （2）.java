public class Solution {
    // 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
    public int solution(int[] sides) {
        int answer = 0;

        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        // min + x > max
        // x의 시작은 max-min+1
        for(int i=max-min+1; i<=max; i++) {
            if(i+min > max)
                answer++;
        }

        // min + max > x
        // x의 시작은 max + 1
        for(int i=max+1; i<max+min; i++) {
            answer++;
        }

        return answer;
    }
}