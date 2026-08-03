import java.util.Scanner;

public class Main {
    public static int[] faces = {1, 2, 3}; // top, front, right
    public static int[] nextFaces = {0, 0, 0};
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        char[] directions = new char[m];
        for (int i = 0; i < m; i++) {
            directions[i] = sc.next().charAt(0);
        }
        grid = new int[n][n];
        grid[x][y] = 6;

        int[] dirMapper = new int[128];
        dirMapper['L'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['D'] = 3;

        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        
        for (char dir : directions) {
            int nextX = x + dx[dirMapper[dir]];
            int nextY = y + dy[dirMapper[dir]];
            if (inRange(nextX, nextY, n)) {
                if (dir == 'L') {
                    rollLeft();
                } else if (dir =='R') {
                    rollRight();
                } else if (dir == 'U') {
                    rollUp();
                } else if (dir == 'D') {
                    rollDown();
                }
                grid[nextX][nextY] = (7 - faces[0]);
                x = nextX; y = nextY;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += grid[i][j];
            }
        }

        System.out.println(answer);
    }

    public static boolean inRange(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void rollLeft() {
        for (int i = 0; i < 3; i++)
            nextFaces[i] = 0;
        
        nextFaces[0] = faces[2]; // top
        nextFaces[1] = faces[1]; // front
        nextFaces[2] = 7 - faces[0]; // right

        for (int i = 0; i < 3; i++)
            faces[i] = nextFaces[i];
    }

    public static void rollRight() {
        for (int i = 0; i < 3; i++)
            nextFaces[i] = 0;
        
        nextFaces[0] = 7 - faces[2]; // top
        nextFaces[1] = faces[1]; // front
        nextFaces[2] = faces[0]; // right

        for (int i = 0; i < 3; i++)
            faces[i] = nextFaces[i];
    }

    public static void rollUp() {
        for (int i = 0; i < 3; i++)
            nextFaces[i] = 0;
        
        nextFaces[0] = faces[1]; // top
        nextFaces[1] = 7 - faces[0]; // front
        nextFaces[2] = faces[2]; // right

        for (int i = 0; i < 3; i++)
            faces[i] = nextFaces[i];
    }

    public static void rollDown() {
        for (int i = 0; i < 3; i++)
            nextFaces[i] = 0;
        
        nextFaces[0] = 7 - faces[1]; // top
        nextFaces[1] = faces[0]; // front
        nextFaces[2] = faces[2]; // right

        for (int i = 0; i < 3; i++)
            faces[i] = nextFaces[i];
    }

}