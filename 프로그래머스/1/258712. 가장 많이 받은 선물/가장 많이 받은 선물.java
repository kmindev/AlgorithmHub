import java.util.*;

class Solution {
    
    Map<String, List<String>> toMap = new HashMap<>();
    Map<String, List<String>> fromMap = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        
        for(String name : friends) {
            toMap.put(name, new ArrayList<>());
            fromMap.put(name, new ArrayList<>());
        }
        
        for(String info : gifts) {
            String[] split = info.split(" ");
            String from = split[0];
            String to = split[1];
            toMap.get(from).add(to);
            fromMap.get(to).add(from);
        }
        
        int answer = 0;
        for(String name : friends) {
            int count = 0;
            
            for(String to : friends) {
                if(name.equals(to)) {
                    continue;
                }
                int size1 = exchangeSize(name, to); // a => b
                int size2 = exchangeSize(to, name); // b => a
                
                if(size1 > size2) {
                    count++;
                } else if((size1 == 0 && size2 == 0) || size1 == size2 ) {
                    int score1 = toMap.get(name).size() - fromMap.get(name).size(); // a 선물 지수
                    int score2 = toMap.get(to).size() - fromMap.get(to).size(); // b 선물 지수
                    if(score1 > score2) {
                        count++;
                    }
                }
            }
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
    
    private int exchangeSize(String from, String to) {
        int count = 0;
        for(String name : toMap.get(from)) {
            if(name.equals(to)) {
                count++;
            }
        }
        return count;
    }
}