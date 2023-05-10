import java.util.Arrays;
class Solution {
	public String solution(String my_string) {

		String toLowerCase = my_string.toLowerCase();
		char[] arr = toLowerCase.toCharArray();
		Arrays.sort(arr);

		return String.valueOf(arr);
	}
}