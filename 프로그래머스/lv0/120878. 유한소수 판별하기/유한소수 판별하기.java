class Solution {
	public int solution(int a, int b) {
		/**
		 * 1. 최대 공약수를 구해서 기약분수로 만든다. 2. 분모의 소인수를 구한다. 3. 분모의 소인수가 2, 5만 존재하면 유한소수, 나머지는
		 * 무한소수
		 */

		int greatestCommonDivisor = findGreatestCommonDivisor(a, b); // 최대공약수를 저장할 변수

		// 기약분수 => 최대공약수로 약분
		if (greatestCommonDivisor > 0) {
			a /= greatestCommonDivisor; // 기약 분수
			b /= greatestCommonDivisor; // 기약 분수

			if (a == b) // 정수이면 유한소수
				return 1;
		}

		boolean isCheck = false;

		loop1: for (int i = 2; i <= b; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) // 소수가 아님
					continue loop1;
			}

			// i는 소수
			// b의 소인수 구하기
			// 소인수: b를 나누어 떨어뜨린 약수 중 소수인 약수
			// b % i ==> 소인수
			// 소인수 중에 2와 5만 존재하면 유한소수
			if (b % i == 0) {
				if (i != 2 && i != 5) { // 유한소수가 아님
					isCheck = true;
				}
			}
		}

		if (!isCheck) { // 유한 소수
			return 1;
		}

		return 2;
	}

	private int findGreatestCommonDivisor(int a, int b) {

		for (int i = a; i > 1; i--) { // 최대공약수 찾기
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 0;
	}
}