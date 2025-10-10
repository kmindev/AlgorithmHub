import java.util.*;

class Solution {
    Map<String, Integer> scoreMap;
    
    public String solution(String[] survey, int[] choices) {
        init(survey, choices);
        return solve(survey, choices);
    }
    
    private void init(String[] survey, int[] choices) {
        scoreMap = new HashMap<>();
    }
    
    private String solve(String[] survey, int[] choices) {
        int surveyLen = survey.length;
        for(int i = 0; i < surveyLen; i++){
            String[] types = survey[i].split("");
            int choice = choices[i];
            typeChoice(types, choice);
        }
        return makeType();
    }
    
    private void typeChoice(String[] types, int choice) {
        if(choice == 4) {
            return;
        }
        
        String type = "";
        int score = 0;
        
        if(choice < 4) {
            type = types[0];
            score = 4 - choice;
        } else {
            type = types[1];
            score = choice - 4;
        }
       
        scoreMap.put(type, scoreMap.getOrDefault(type, 0) + score);
    }
    
    private String makeType() {
        StringBuilder answer = new StringBuilder();
        answer.append(getType("R", "T"));
        answer.append(getType("C", "F"));
        answer.append(getType("J", "M"));
        answer.append(getType("A", "N"));
        return answer.toString();
    }
    
    private String getType(String a, String b) {

        int aScore = scoreMap.getOrDefault(a, 0);
        int bScore = scoreMap.getOrDefault(b, 0);
        
        if(aScore >= bScore) {
            return a;
        } else {
            return b;
        }
    }
    
}