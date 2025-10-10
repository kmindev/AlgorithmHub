import java.util.*;

class Solution {
    public int solution(String dartResult) {
        return solve(dartResult);
    }
    
    private int solve(String dartResult) {
        int[] temp = new int[3];
        
        int idx = 0;
        for(int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            
            if(Character.isDigit(ch)) {
                temp[idx] = ch - '0';
                if(ch == '1' && dartResult.charAt(i + 1) == '0') {
                    i++;
                    temp[idx] = 10;
                }
                continue;
            }
            
            if(ch == 'S') {
                temp[idx] = temp[idx];
                idx++;
            } else if(ch == 'D') {
                temp[idx] = (int) Math.pow(temp[idx], 2);
                idx++;
            } else if (ch == 'T') {
                temp[idx] = (int) Math.pow(temp[idx], 3);
                idx++;
            } else if(ch == '*') {
                temp[idx - 1] = temp[idx - 1] * 2;
                if(idx - 2 >= 0) {
                    temp[idx - 2] = temp[idx - 2] * 2;
                }
            } else if (ch == '#') {
                temp[idx - 1] = temp[idx - 1] * (-1);
            }
        }
        
        return Arrays.stream(temp).sum();
    }
}