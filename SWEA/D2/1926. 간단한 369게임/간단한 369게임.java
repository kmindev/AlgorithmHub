import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=1; i<=N; i++) {
            String num = Integer.toString(i);
            num = num.replaceAll("3", "-");
            num = num.replaceAll("6", "-");
            num = num.replaceAll("9", "-");

            if(num.contains("-")) {
                num = num.replaceAll("0", "");
                num = num.replaceAll("1", "");
                num = num.replaceAll("2", "");
                num = num.replaceAll("4", "");
                num = num.replaceAll("5", "");
                num = num.replaceAll("7", "");
                num = num.replaceAll("8", "");
            }

            System.out.print(num+" ");




        }


    }

}