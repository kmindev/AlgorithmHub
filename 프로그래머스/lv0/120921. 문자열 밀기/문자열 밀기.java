class Solution {
	public int solution(String A, String B) {
		int answer = -1;

		if (A.equals(B))
			return 0;

		StringBuilder AString = new StringBuilder(A);

		for (int i = 0; i < A.length(); i++) {

			AString.insert(0, AString.charAt(AString.length() - 1));
			AString.deleteCharAt(AString.length() - 1);

			if (AString.toString().equals(B)) {
				return i + 1;
			}
		}

		return answer;
	}
}