import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        int nCompIndex = participant.length - 1;
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                nCompIndex = i;
                break;
            }
        }

        return participant[nCompIndex];
    }
}