class Solution {
	public int solution(int n) {
		int count = 0;
		int i = 1;

		for (i = 1; i <= n + count; i++) { // 3의 배수와 3을 포함하고 있는 수만큼 추가로 반복 수행
			if (i % 3 == 0 || Integer.toString(i).contains("3")) // 3의 배수이거나 3을 포함하고 있으면 증가
				count++;
		}

		return i - 1;
	}
}