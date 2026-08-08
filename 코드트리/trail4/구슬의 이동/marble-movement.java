import java.util.*;

class Bid {
    public int name, dir, speed;
    public Bid(int name, int dir, int speed) {
        this.name = name;
        this.dir = dir;
        this.speed = speed;
    }
}

public class Main {
    public static List<Bid>[][] bidGrid;
    public static List<Bid>[][] nextGrid;
    public static int N;
    public static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        K = sc.nextInt();

        bidGrid = new ArrayList[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                bidGrid[i][j] = new ArrayList<Bid>();
        nextGrid = new ArrayList[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                nextGrid[i][j] = new ArrayList<Bid>();
        
        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['D'] = 1;
        dirMapper['R'] = 2;
        dirMapper['L'] = 3;

        for (int i = 0; i < M; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            char d = sc.next().charAt(0);
            int v = sc.nextInt();
            
            bidGrid[r][c].add(new Bid(i, dirMapper[d], v));
        }

        while (T-- > 0) {
        //   System.out.println("grid : ");
        //   printGrid(bidGrid);
        //   System.out.println("grid end");
          simulate();
        }
        // printGrid(bidGrid);

        int ans = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                ans += bidGrid[x][y].size();
            }
        }
        System.out.print(ans);
    }

    public static void simulate() {
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int k = 0; k < bidGrid[x][y].size(); k++) {
                    Bid bid = bidGrid[x][y].get(k);

                    int curX = x, curY = y;
                    int curDir = bid.dir;
                    int dist = bid.speed;
                    while (dist-- > 0) {
                        int nextX = curX + dx[curDir];
                        int nextY = curY + dy[curDir];

                        if (inRange(nextX, nextY)) {
                            curX = nextX;
                            curY = nextY;
                        } else {
                            // 방향 전환 시 시간 소요 없음
                            curDir = (1 ^ curDir);
                            curX = curX + dx[curDir];
                            curY = curY + dy[curDir];
                        }
                    }

                    nextGrid[curX][curY].add(new Bid(bid.name, curDir, bid.speed));
                }
            }
        }

        // 겹쳐진 구슬에 대한 충돌처리
        for (int x = 0; x < N; x++)  {
            for (int y = 0; y < N; y++) {
                if (nextGrid[x][y].size() > K) {
                    Collections.sort(nextGrid[x][y], (b1, b2) -> {
                        if (b2.speed == b1.speed) {
                            return Integer.compare(b2.name, b1.name);
                        } else {
                            return Integer.compare(b2.speed, b1.speed);
                        }
                    });
                }
                bidGrid[x][y].clear();
                for (int i = 0; i < Math.min(K, nextGrid[x][y].size()); i++) {
                    bidGrid[x][y].add(nextGrid[x][y].get(i));
                }
            }
        }

        // nextGrid 초기화
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                nextGrid[x][y].clear();
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void printGrid(List<Bid>[][] grid) {
        char[] dirMapper = new char[] {'U', 'D', 'R', 'L'};
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (grid[x][y].isEmpty()) continue;
                sb.append("x: " + x + ",y: " + y + "\n");
                for (Bid bid : grid[x][y]) {
                    sb.append(" name: " + bid.name + ",d: " + dirMapper[bid.dir] + ",s: " + bid.speed + "\n");
                }
            }
        }
        System.out.print(sb);
    }

}