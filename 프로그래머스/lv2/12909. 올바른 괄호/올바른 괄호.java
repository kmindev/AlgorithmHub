import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<String> q = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++) {
            String s1 = s.substring(i, i+1);
            if(s1.equals("(")) {
                q.offer(s1);
            } else {
                if(q.poll() == null)
                    return false;
            }
        }

        return q.size() == 0;
    }
}