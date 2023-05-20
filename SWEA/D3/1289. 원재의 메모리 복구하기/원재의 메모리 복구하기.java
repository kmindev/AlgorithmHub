import java.util.Arrays;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String state = sc.next();
            char current = '0';
            int result = 0;
            for (int i = 0; i < state.length(); i++) {
                if (current != state.charAt(i)) {
                    result++;
                    current = state.charAt(i);
                }
            }
            System.out.println("#" + tc + " " + result);
        }


    }

}
