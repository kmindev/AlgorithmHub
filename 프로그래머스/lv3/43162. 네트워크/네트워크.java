class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        
        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers, visited);
            }
        }
        
        return answer;
    }
    
    private void dfs(int x, int[][] computers, boolean[] visited) {
        visited[x] = true;
        
        for(int i=0; i<computers.length; i++) {
            if(computers[x][i]==1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}