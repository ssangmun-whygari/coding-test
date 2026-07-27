import java.util.*;
public class Main {
    public static int N;
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();

        rotate(r, c, m1, m2, m3, m4, dir);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int r, int c, int m1, int m2, int m3, int m4, int dir) {
        Deque<Integer> deque = new ArrayDeque<>();

        // 반시계 + 시계 방향
        int[] dy = new int[] {1, -1, -1, 1, -1, 1, 1, -1};
        int[] dx = new int[] {-1, -1, 1, 1, -1, -1, 1, 1};

        if (dir == 0) { // 반시계
            int[] moves = new int[] {m1, m2, m3, m4};
            for (int d = 0; d < 4; d++) {
                for (int m = 0; m < moves[d]; m++) {
                    deque.add(grid[r][c]);
                    r += dx[d]; c += dy[d];
                }
            }
            int temp = deque.pollLast();
            deque.addFirst(temp);
            for (int d = 0; d < 4; d++) {
                for (int m = 0; m < moves[d]; m++) {
                    grid[r][c] = deque.poll();
                    r += dx[d]; c += dy[d];
                }
            }
        } else { // 시계
            int[] moves = new int[] {m2, m1, m4, m3};
            for (int d = 0; d < 4; d++) {
                for (int m = 0; m < moves[d]; m++) {
                    deque.add(grid[r][c]);
                    r += dx[d + 4]; c += dy[d + 4];
                }
            }
            int temp = deque.pollLast();
            deque.addFirst(temp);
            for (int d = 0; d < 4; d++) {
                for (int m = 0; m < moves[d]; m++) {
                    grid[r][c] = deque.poll();
                    r += dx[d + 4]; c += dy[d + 4];
                }
            }
        }
    }
}