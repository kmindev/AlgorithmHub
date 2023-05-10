class Solution {
	public int solution(String[] spell, String[] dic) {

		for (String str1 : dic) {

			if (str1.length() != spell.length) // spell의 원소를 모두 조합해서 dic 원소를 만들기 때문에 길이는 무조건 같음
				continue;

			for (String str2 : spell) {
				str1 = str1.replaceFirst(str2, "1");
			}

			System.out.println(str1);

			boolean isCheck = false;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != '1') {
					isCheck = true;
				}
			}

			if (!isCheck)
				return 1;

		}

		return 2;
	}
}