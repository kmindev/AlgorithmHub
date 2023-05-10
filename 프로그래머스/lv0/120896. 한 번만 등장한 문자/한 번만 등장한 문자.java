import java.util.ArrayList;
import java.util.Collections;
class Solution {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}

		ArrayList<Character> sort = new ArrayList<>();

		for (int i = 0; i < sb.length(); i++) {
			sort.add(sb.charAt(i));
		}

		Collections.sort(sort);

		return sort.toString().replaceAll("\\[|\\, |\\]", "");

	}
}