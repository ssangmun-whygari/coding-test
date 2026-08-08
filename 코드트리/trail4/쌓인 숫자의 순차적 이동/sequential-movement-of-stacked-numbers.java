import java.util.*;

class Pos {
    public int x, y, idx;
    Pos(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

public class Main {
    public static int[][][] grid;
    public static int N;
    public static int[] dx = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dy = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        // 7 |
        // 1 7 | 뒤에서 꺼내서
        // 1 7 8 | 앞으로 집어넣음

        // M
        // N * N
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();

        grid = new int[N][N][N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j][0] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            simulate(num);
            // System.out.println("grid : ");
            // printGrid(grid);
            // System.out.println("grid end");
        }

        printGrid(grid);
    }

    public static void printGrid(int[][][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int lastIdx = getLastIdx(grid[x][y]);
                if (lastIdx < 0) {
                    sb.append("None\n");
                } else {
                    for (int i = 0; i <= lastIdx; i++) {
                        sb.append(grid[x][y][i] + " ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }

    public static void simulate(int num) {
        // 격자를 순회하면서 num이 있는 위치 찾기
        Pos pos = getNumPos(num);
        Pos nextPos = getLargestNearNumPos(pos);
        if (nextPos.x == -1 || nextPos.y == -1) return; // 주변 8칸이 다 비었음

        int dist = pos.idx + 1;
        // dist만큼 nextPos의 값들을 오른쪽으로 옮긴다.
        int[] arr = grid[nextPos.x][nextPos.y];
        int lastIdx = getLastIdx(arr);
        for (int i = lastIdx; i >= 0; i--) {
            arr[i + dist] = arr[i];
        }
        // nextPos의 앞부터 옮길 부분 수열을 복사해넣는다.
        int idx = pos.idx;
        for (int i = 0; i <= pos.idx; i++) {
            arr[i] = grid[pos.x][pos.y][i];
        }
        // 옮긴 수들을 pos에서 지운다.
        lastIdx = getLastIdx(grid[pos.x][pos.y]);
        for (int i = idx + 1; i <= lastIdx; i++) {
            grid[pos.x][pos.y][i - idx - 1] = grid[pos.x][pos.y][i];
        }
        for (int i = lastIdx - idx; i <= lastIdx; i++) {
            grid[pos.x][pos.y][i] = 0;
        }
    }

    public static int getLastIdx(int[] arr) {
        int lastIdx = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return lastIdx = i - 1;
            }
        }
        return lastIdx;
    }

    public static Pos getLargestNearNumPos(Pos pos) {
        int maxVal = -1, nextX = -1, nextY = -1;
        for (int d = 0; d < 8; d++) {
            int candX = pos.x + dx[d];
            int candY = pos.y + dy[d];
            if (!inRange(candX, candY)) continue;

            for (int i = 0; i < N * N; i++) {
              int candVal = grid[candX][candY][i];
              if (candVal == 0) break;
              if (maxVal < candVal) {
                maxVal = candVal;
                nextX = candX;
                nextY = candY;
              }
            }
        }
        return new Pos(nextX, nextY, 0); // 가장 위에 올려져있음
    }

    public static Pos getNumPos(int num) {
        Pos pos = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N * N; k++) {
                    if (grid[i][j][k] == 0) {
                        continue;
                    } else if (grid[i][j][k] == num) {
                        pos = new Pos(i, j, k);
                        break;
                    }
                }
                if (pos != null) break;
            }
            if (pos != null) break;
        }
        return pos;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}