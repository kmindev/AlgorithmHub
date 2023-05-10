import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
	public int[] solution(int[][] score) {
		int[] answer = new int[score.length];
		ArrayList<Integer> arrSum = new ArrayList<>();

		for (int i = 0; i < score.length; i++) {
			answer[i] = (score[i][0] + score[i][1]);
			arrSum.add((score[i][0] + score[i][1]));
		}
		Collections.sort(arrSum);
		Collections.reverse(arrSum);

		for (int i = 0; i < arrSum.size(); i++) {
			answer[i] = arrSum.indexOf(answer[i]) + 1;
		}

		return answer;
	}
}