class Solution {
	public int solution(String[] babbling) {
		int answer = 0;

		String[] baby = { "aya", "ye", "woo", "ma" };

		for (int i = 0; i < babbling.length; i++) {
			String word = babbling[i];

			for (int j = 0; j < baby.length; j++) {
				word = word.replace(baby[j], "1");
			}

			boolean isCheck = true;

			for (int k = 0; k < word.length(); k++) {
				if (!(word.substring(k, k + 1).equals("1"))) {
					isCheck = false;
					break;
				}

			}

			if (isCheck)
				answer++;
		}

		return answer;
	}
}