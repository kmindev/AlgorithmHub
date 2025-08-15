import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int MAP_SIZE = 4;
    static int MAX = Integer.MIN_VALUE;

    // 0(북) ~ 7(북서) => 반시계 방향
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        // 4 x 4 크기, 물고기 1 ~ 16
        int[][] map = new int[MAP_SIZE][MAP_SIZE];
        Map<Integer, Fish> fishMap = new HashMap<>();
        for (int i = 0; i < MAP_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_SIZE; j++) {
                int num = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken()) - 1; // 방향 1~8을 0~7로 변환
                map[i][j] = num;
                fishMap.put(num, new Fish(num, i, j, direction));
            }
        }

        // 상어가 (0,0) 물고기 먹고 시작
        int num = map[0][0];
        Fish fish = fishMap.get(num);
        fishMap.remove(num);
        map[0][0] = -1; // 상어 위치는 -1
        int sharkDirection = fish.direction;

        dfs(map, fishMap, 0, 0, sharkDirection, num);

        bw.write(MAX + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int[][] curMap, Map<Integer, Fish> curFishMap, int sharkX, int sharkY, int sharkDirection,
                    int sum) {
        MAX = Math.max(MAX, sum);

        // 물고기 이동
        int[][] newMap = copyMap(curMap);
        Map<Integer, Fish> newFishMap = copyFishMap(curFishMap);
        for (int i = 1; i <= 16; i++) {
            Fish fish = newFishMap.get(i);
            if (fish != null) {
                fish.move(newMap, newFishMap);
            }
        }

        // 상어 이동
        boolean canMove = false;
        for (int i = 1; i < MAP_SIZE; i++) {
            int nx = sharkX + dx[sharkDirection] * i;
            int ny = sharkY + dy[sharkDirection] * i;

            if (nx < 0 || nx >= MAP_SIZE || ny < 0 || ny >= MAP_SIZE) {
                continue;
            }
            if (newMap[nx][ny] <= 0) { // 빈칸(0) 또는 상어(-1)
                continue;
            }

            canMove = true;
            int targetNum = newMap[nx][ny];
            Fish targetFish = newFishMap.get(targetNum);
            if (targetFish == null) {
                continue;
            }

            // 상어 이동 준비
            int[][] nextMap = copyMap(newMap);
            Map<Integer, Fish> nextFishMap = copyFishMap(newFishMap);
            nextMap[sharkX][sharkY] = 0; // 원래 위치 빈칸
            nextMap[nx][ny] = -1; // 새 위치에 상어
            nextFishMap.remove(targetNum); // 먹힌 물고기 제거

            dfs(nextMap, nextFishMap, nx, ny, targetFish.direction, sum + targetNum);
        }

        // 상어가 이동할 수 없으면 종료 (MAX는 이미 갱신됨)
    }

    static int[][] copyMap(int[][] origin) {
        int[][] copy = new int[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            System.arraycopy(origin[i], 0, copy[i], 0, MAP_SIZE);
        }
        return copy;
    }

    static Map<Integer, Fish> copyFishMap(Map<Integer, Fish> origin) {
        Map<Integer, Fish> copy = new HashMap<>();
        for (Map.Entry<Integer, Fish> e : origin.entrySet()) {
            Fish f = e.getValue();
            copy.put(e.getKey(), new Fish(f.num, f.x, f.y, f.direction));
        }
        return copy;
    }

    static class Fish {
        int num;
        int x;
        int y;
        int direction;

        public Fish(int num, int x, int y, int direction) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void move(int[][] map, Map<Integer, Fish> fishMap) {
            for (int i = 0; i < 8; i++) {
                int nd = (this.direction + i) % 8;
                int nx = this.x + dx[nd];
                int ny = this.y + dy[nd];

                if (nx < 0 || nx >= MAP_SIZE || ny < 0 || ny >= MAP_SIZE || map[nx][ny] == -1) {
                    continue; // 경계 밖이거나 상어 위치면 이동 불가
                }

                int targetNum = map[nx][ny];
                if (targetNum == 0) { // 빈칸
                    map[this.x][this.y] = 0;
                    this.x = nx;
                    this.y = ny;
                    map[nx][ny] = this.num;
                } else { // 다른 물고기
                    Fish targetFish = fishMap.get(targetNum);
                    map[this.x][this.y] = targetNum;
                    map[targetFish.x][targetFish.y] = this.num;
                    int tempX = this.x, tempY = this.y;
                    this.x = targetFish.x;
                    this.y = targetFish.y;
                    targetFish.x = tempX;
                    targetFish.y = tempY;
                }
                this.direction = nd;
                return;
            }
        }
    }
}