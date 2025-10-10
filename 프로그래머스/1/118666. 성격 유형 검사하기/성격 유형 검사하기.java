import java.util.*;

class Solution {
    Map<Character, Integer> scoreMap = new HashMap<>();
    char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    
    public String solution(String[] survey, int[] choices) {
        return solve(survey, choices);
    }
    
    private String solve(String[] survey, int[] choices) {
        int surveyLen = survey.length;
        for(int i = 0; i < surveyLen; i++){
            typeChoice(survey[i], choices[i]);
        }
        return makeType();
    }
    
    private void typeChoice(String types, int choice) {
        if(choice == 4) {
            return;
        }
        char type = '0';
        int score = 0;
        
        if(choice < 4) {
            type = types.charAt(0);
            score = 4 - choice;
        } else {
            type = types.charAt(1);
            score = choice - 4;
        }
        scoreMap.put(type, scoreMap.getOrDefault(type, 0) + score);
    }
    
    private String makeType() {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < types.length; i++) {
            answer.append(getType(types[i][0], types[i][1]));
        }
        return answer.toString();
    }
    
    private char getType(char a, char b) {
        int aScore = scoreMap.getOrDefault(a, 0);
        int bScore = scoreMap.getOrDefault(b, 0);
        
        if(aScore >= bScore) {
            return a;
        } else {
            return b;
        }
    }
    
}