import java.util.StringTokenizer;
class Solution {
	public int solution(String my_string) {

		StringTokenizer st = new StringTokenizer(my_string, " ");
		int num = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.equals("+")) {
				num += Integer.parseInt(st.nextToken());
			} else if (token.equals("-")) {
				num -= Integer.parseInt(st.nextToken());
			} else {
				num = Integer.parseInt(token);
			}
		}

		return num;
	}
}