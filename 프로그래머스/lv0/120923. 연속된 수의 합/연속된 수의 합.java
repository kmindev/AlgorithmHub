class Solution {
	public int[] solution(int num, int total) {
		int[] answer = new int[num];
		int start = 0;
		while (true) {
			int sum = 0;
			int index = 0;
			for (int i = start; i < start + num; i++) {
				sum += i;
				answer[index] = i;
				index++;
			}
			if (sum < total) {
				start++;
			} else if (sum > total) {
				start--;
			} else {
				return answer;
			}
		}
	}
}