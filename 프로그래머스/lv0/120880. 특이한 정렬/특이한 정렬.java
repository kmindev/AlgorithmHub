class Solution {
	public int[] solution(int[] numlist, int n) {

		int[] numN = new int[numlist.length]; // 거리를 구하기 위한 배열

		for (int i = 0; i < numlist.length; i++) {
			numN[i] = numlist[i] - n; // n과 numlist 원소의 차이를 numN에 저장
		}

		for (int i = 0; i < numN.length - 1; i++) { // 절대값으로 오름차순 정렬 시작
			for (int j = i + 1; j < numN.length; j++) {
				if (Math.abs(numN[i]) == Math.abs(numN[j])) { // 거리가 같을 때
					if (numN[i] < numN[j]) { // 큰수를 앞으로 보낸다.
						swap(i, j, numlist, numN);
					}

				} else if (Math.abs(numN[i]) > Math.abs(numN[j])) { // 거리가 가까울 때
					swap(i, j, numlist, numN);
				}
			}
		}

		return numlist;
	}

	private static void swap(int i, int j, int[] arr1, int[] arr2) {
		int temp1 = arr1[i];
		arr1[i] = arr1[j];
		arr1[j] = temp1;

		int temp2 = arr2[i];
		arr2[i] = arr2[j];
		arr2[j] = temp2;
	}
}