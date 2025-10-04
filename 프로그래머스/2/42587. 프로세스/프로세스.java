import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            int num = i;
            int priority = priorities[i];
            q.offer(new Process(num, priority));
        }
        
        int order = 0;
        while(!q.isEmpty()) {
            Process cur = q.poll();
            
            boolean hasHigher = false;
            for(Process process : q) {
                if(process.priority > cur.priority) {
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher) {
                q.offer(cur);
            } else {
                order++;
                if(cur.num == location) {
                    break;
                }
            }
        }
        return order;
    }
    
    static class Process {
        int num;
        int priority;
        
        Process(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }
}