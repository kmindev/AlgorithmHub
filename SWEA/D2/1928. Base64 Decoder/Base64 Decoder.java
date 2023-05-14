
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.Base64;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        // 문자에 해당하는 값으로 변환 -> 이진수로 변환 -> 6자리 씩 이진수를 배열에 넣고 -> 8개씩 끊어서 10진수 변환 -> 아스키코드표를 통해 문자로 변환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
            String s = br.readLine();
            String result = new String(Base64.getDecoder().decode(s))
;
            bw.write("#"+tc+" "+result);
            bw.newLine(); // 줄바꿈
    
            bw.flush();
            
        }
        
     
	}
}