import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
		 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toUpperCase();
		
		

		int a[] = new int[26];
		int max= - 1;
		char ch = '?';
		
		for(int i=0; i<s.length(); i++) {
			int n = s.charAt(i)-65;
			a[n]++;
		}
		
		for(int j=0; j<a.length; j++) {
			if(a[j]>max) {
				max = a[j];
				ch = (char)(j+65);
			}else if(a[j]==max) {
				ch = '?';
			}
		}
		System.out.println(ch);
			
		
	}
}