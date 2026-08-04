import java.util.*;

class Snake {
    public Deque<Pos> body = new ArrayDeque<>();
    public boolean[][] bodyGrid;
}

class Pos {
    public int x;
    public int y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int headX = 0;
    public static int headY = 0;
    public static boolean[][] apple;
    public static int N;
    public static int[] dx = new int[] {-1, 1, 0, 0}; // U, D, L, R
    public static int[] dy = new int[] {0, 0, -1, 1};
    public static int[] dirMapper = new int[128];
    public static Snake snake;
    public static int elapsedTime = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        apple = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            apple[r][c] = true;
        }
        snake = new Snake();
        snake.body.add(new Pos(0, 0));
        snake.bodyGrid = new boolean[N][N];
        snake.bodyGrid[0][0] = true;

        dirMapper['U'] = 0;
        dirMapper['D'] = 1;
        dirMapper['L'] = 2;
        dirMapper['R'] = 3;

        for (int i = 0; i < K; i++) {
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();
            boolean result = false;
            for (int j = 0; j < dist; j++) {
                result = move(dir);
                elapsedTime++;
                if (result == false) break;
            }
            if (result == false) break;
        }

        System.out.println(elapsedTime);
    }

    public static boolean move(char dir) {
        // System.out.println("apple : ");
        // printGrid(apple);
        // System.out.println("bodyGrid : ");
        // printGrid(snake.bodyGrid);

        int d = dirMapper[dir];
        int headX = snake.body.peekLast().x;
        int headY = snake.body.peekLast().y;

        int nextX = headX + dx[d];
        int nextY = headY + dy[d];
        // 범위에서 벗어나면 조기종료
        if (!inRange(nextX, nextY)) {
            return false;
        }
        // 이동할 때 꼬리가 아닌 몸통을 물면 조기종료
        Pos tailPos = snake.body.peekFirst();
        if ((tailPos.x != nextX || tailPos.y != nextY) && snake.bodyGrid[nextX][nextY] == true) {
            return false;
        }

        snake.body.add(new Pos(nextX, nextY));
        snake.bodyGrid[nextX][nextY] = true;
        // 사과가 없으면 꼬리를 삭제한다.
        if (apple[nextX][nextY] == false) {
            tailPos = snake.body.pollFirst();
            snake.bodyGrid[tailPos.x][tailPos.y] = false;
        } else {
            // 사과가 있으면 싸과를 삭제한다.
            apple[nextX][nextY] = false;
        }
        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void printGrid(boolean[][] grid) {
      for (boolean[] row : grid) {
        System.out.println(Arrays.toString(row));
      }
    }
}