import java.util.*;

class Solution {
    int[] answer = {-1};
    int[] apeach;
    int max;

    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        dfs(new int[11], 0, 0, n);
        return answer;
    }

    private void dfs(int[] ryan, int start, int used, int n) {
        if (used == n) {
            compareScore(ryan);
            return;
        }

        for (int i = start; i < 11; i++) {
            ryan[i]++;
            dfs(ryan, i, used + 1, n);
            ryan[i]--;
        }
    }

    private void compareScore(int[] ryan) {
        int ryanScore = 0, apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            if (ryan[i] == 0 && apeach[i] == 0) continue;
            if (ryan[i] > apeach[i]) ryanScore += 10 - i;
            else apeachScore += 10 - i;
        }

        int diff = ryanScore - apeachScore;
        if (diff <= 0) return;

        if (diff > max || (diff == max && isBetter(ryan, answer))) {
            max = diff;
            answer = ryan.clone();
        }
    }

    private boolean isBetter(int[] r1, int[] r2) {
        for (int i = 10; i >= 0; i--) {
            if (r1[i] != r2[i]) return r1[i] > r2[i];
        }
        return false;
    }
}
