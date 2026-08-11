import java.util.Scanner;
public class Main {
    public static int k;
    public static int n;
    public static int m;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int[] moves = new int[n]; // 턴마다 말에게 할당되는 이동량
        for (int i = 0; i < n; i++) {
            moves[i] = sc.nextInt();
        }
        
        int[] board = new int[k];//말마다 현재 놓여진 위치, board[0] = 1 -> 0번 말이 1의 위치에 있음
        recur(board, moves, 0);
        System.out.println(ans);
    }

    public static void recur(int[] board, int[] moves, int turn) {
        if (turn == n) {
            ans = Math.max(ans, calcScore(board));
            return;
        }

        for (int i = 0; i < k; i++) {
            int move = moves[turn]; // 움직여야 하는 양
            board[i] = board[i] + move; // i번 말을 move만큼 움직인다.
            recur(board, moves, turn + 1);
            board[i] = board[i] - move;
        }
    }

    public static int calcScore(int[] board) {
        int score = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] >= m - 1) {
                score++;
            }
        }
        return score;
    }
}