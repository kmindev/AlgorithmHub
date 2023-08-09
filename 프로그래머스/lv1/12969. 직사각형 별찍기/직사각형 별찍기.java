import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<b; i++) {
            for(int j=0; j<a; j++) {
                answer.append("*");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}