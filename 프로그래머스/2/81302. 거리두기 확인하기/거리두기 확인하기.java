import java.util.*;

class Solution {
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    
    public int[] solution(String[][] places) {
        return solve(places);
    }
    
    private int[] solve(String[][] places) {   
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
            char[][] map = toMap(places[i]);
            answer[i] = safeMap(map);
        }
        return answer;
    }
    
    private char[][] toMap(String[] place) {
        char[][] map = new char[place.length][place[0].length()];
        for(int i = 0; i < place.length; i++) {
            String line = place[i];
            for(int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                map[i][j] = ch;
            }
        }
        return map;
    }
    
    private int safeMap(char[][] map) {
        boolean isOk = true;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 'P') {
                    if(!bfs(map, i, j)) {
                        isOk = false;
                    }
                }
            }
        }
        return isOk ? 1 : 0;
    }
    
    private boolean bfs(char[][] map, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || (nx == x && ny == y)) {
                    continue;
                }
                
                int distance = Math.abs(nx - x) + Math.abs(ny - y);
                
                if(map[nx][ny] == 'P' && distance <= 2) {
                    return false;
                } else if(map[nx][ny] == 'O' && distance < 2) {
                    q.offer(new Point(nx, ny));
                }
            }
        }
        
        return true;
    }
    
    static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}