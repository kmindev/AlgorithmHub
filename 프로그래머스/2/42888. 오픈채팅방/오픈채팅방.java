import java.util.*;

class Solution {
    
    Map<String, String> nicknameMap = new HashMap<>();
    
    public String[] solution(String[] record) {
        return solve(record);
    }
    
    private String[] solve(String[] record) {
        List<String> result = new ArrayList<>();
        
        for(String info : record) {
            String[] token = info.split(" ");
            String command = token[0];
            
            if(command.equals("Enter")) {
                String id = token[1];
                String nickname = token[2];
                String text = id + "님이 들어왔습니다.";
                result.add(text);
                nicknameMap.put(id, nickname);
            } else if(command.equals("Leave")) {
                String id = token[1];
                String text = id + "님이 나갔습니다.";
                result.add(text);
            } else if(command.equals("Change")) {
                String id = token[1];
                String nickname = token[2];
                nicknameMap.put(id, nickname);
            }
        }
        
        String[] answer = result.toArray(new String[0]);
        for(int i = 0 ; i < answer.length; i++) {
            String text = answer[i];
            String[] token = text.split("님");
            String id = token[0];
            text = text.replace(id, nicknameMap.get(id));
            answer[i] = text;
        }
        return answer;
    }
    
}