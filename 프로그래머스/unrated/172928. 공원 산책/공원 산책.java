class Solution {
    public int[] solution(String[] park, String[] routes) {
        int xLen = park.length;
        int yLen = park[0].length();
        int x = 0;
        int y = 0;
        
        // 현재 위치를 찾는다.
        Loop1: for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break Loop1;
                }
            }
        }
       
        for(int i=0; i<routes.length; i++) {
            char op = routes[i].charAt(0);
            int n = routes[i].charAt(2) - '0';
            boolean check = false;
            int nx = x;
            int ny = y;
            
            for(int j=0; j<n; j++) {
                // 방향대로 1칸씩 이동한다.
                if(op == 'N') {
                    nx--; 
                } else if(op == 'S') {
                    nx++;
                } else if(op == 'W') {
                    ny--;
                } else if(op == 'E') {
                    ny++;
                }
                
                // 이동한 위치가 조건에 벗어나면 해당 명령은 실행하면 안된다.
                // 실행여부를 체크하기 위한 변수 check에 기록한다.
                if(nx < 0 || ny < 0 || nx > xLen - 1 || ny > yLen - 1 || park[nx].charAt(ny) =='X') {
                    check = true;
                    break;
                } 
            }
            // 명령을 처리할 수 있다면 위치를 이동한다.
            if(!check) {
                x = nx;
                y = ny;
            }
        }

        int[] answer = {x, y};
        return answer;
    }
}