class Solution {
	public int solution(int chicken) {
		int cupon = 0;
		int serviceChiken = 0;

		while (chicken > 0) {

			cupon += chicken % 10;
			chicken /= 10;
			serviceChiken += chicken;

			if (cupon >= 10) {
				serviceChiken++;
				chicken++;
				cupon %= 10;
			}

		}

		return serviceChiken;
	}
}