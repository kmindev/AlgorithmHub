import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] n1 = {1, 2, 3, 4, 5};
        int[] n2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] n3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] result = {0, 0, 0};

        for(int i =0; i<answers.length; i++) {
            if(answers[i] == n1[i % 5]) result[0]++;
            if(answers[i] == n2[i % 8]) result[1]++;
            if(answers[i] == n3[i % 10]) result[2]++;
        }

        int max = Math.max(result[0], Math.max(result[1], result[2]));

        for(int i=0; i<result.length; i++) {
            if(max == result[i])
                answer.add(i+1);
        }

        return answer;
    }
}

