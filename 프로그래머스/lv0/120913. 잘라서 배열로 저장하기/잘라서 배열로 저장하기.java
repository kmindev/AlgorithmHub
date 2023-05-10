class Solution {
	public String[] solution(String my_str, int n) {
		String[] answer;
		int len = my_str.length();
		int remain = len % n;
		System.out.println(remain);

		if (remain != 0) {
			answer = new String[len / n + 1];
		} else {
			answer = new String[len / n];
		}

		for (int i = 0; i < answer.length; i++) {
			answer[i] = i >= len / n ? my_str.substring(i * n, i * n + remain) : my_str.substring(i * n, i * n + n);
		}

		return answer;
	}
}