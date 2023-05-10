import java.util.StringTokenizer;

class Solution {
	public String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];

		for (int i = 0; i < quiz.length; i++) {
			quiz[i] = quiz[i].replace(" ", "");

			StringTokenizer token = new StringTokenizer(quiz[i], "+-=", true);

			String op1Check = token.nextToken();
			int op1;
			if (op1Check.equals("-")) { // 첫번째가 마이너스 이면
				op1 = -Integer.parseInt(token.nextToken());
			} else {
				op1 = Integer.parseInt(op1Check);
			}

			String operator = token.nextToken();

			String op2Check = token.nextToken();
			int op2;
			if (op2Check.equals("-")) { // 첫번째가 마이너스 이면
				op2 = -Integer.parseInt(token.nextToken());
			} else {
				op2 = Integer.parseInt(op2Check);
			}

			token.nextToken(); // = 연산자는 필요없음

			String resCheck = token.nextToken();
			int res;
			if (resCheck.equals("-")) { // 첫번째가 마이너스 이면
				res = -Integer.parseInt(token.nextToken());
			} else {
				res = Integer.parseInt(resCheck);
			}

			int result = operator.equals("+") ? op1 + op2 : op1 - op2;

			if (result == res) {
				answer[i] = "O";
			} else {
				answer[i] = "X";
			}
		}
		return answer;
	}
}