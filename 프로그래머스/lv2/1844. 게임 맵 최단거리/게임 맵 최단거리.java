import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited, 0, 0);
        
        answer = visited[maps.length - 1][maps[0].length - 1]; // 상대 팀 진영 좌표

        if (answer == 0) { // 상대 팀 진영에 도달하지 못한 경우
            answer = -1;
        }

        return answer;
    }
    
    private void bfs(int[][] maps, int[][] visited, int x, int y) {
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y));
        visited[x][y] = 1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[x].length - 1 ) {
                    continue;
                }
                
                if(maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }
    }
    
    public static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
    }
}