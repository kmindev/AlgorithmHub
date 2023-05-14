
import java.awt.geom.AffineTransform;
import java.util.Arrays;
import java.util.Scanner;import javax.print.attribute.ResolutionSyntax;
// 버블 정렬 오름 차순
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
		
			arr = bubbleSort(arr);
			System.out.print("#"+(tc+1)+" ");
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			// Arrays.sort(arr, Collections.reverseOrder()); 내림 차순 정렬
		}
	}
	
	private static int[] bubbleSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int x = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = x;
				}
			}
		}
		return arr;
	}
}