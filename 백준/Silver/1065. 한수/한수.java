import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Scanner 대신 BufferedReader, BufferedWriter 사용

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=1; i<=n; i++) {
			boolean check = hansu(i);
			if(check == true)
				count++;
		}
		System.out.println(count);
	}
	public static boolean hansu(int x) {
		boolean chek = false;
		if(x<100) //99까지는 무조건 한수
			return true;
		else { //100이상
			int a = x%10; //첫째자리
			int b = (x/10)%10; //둘째자리
			int c = x/100; //셋째자리
			
			if((c-b) == (b-a))
				return true;
			else
				return false;
		}
	}
}