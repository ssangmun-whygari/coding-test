import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] player = new char[N];
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            player[i] = sc.next().charAt(0);
            score[i] = sc.nextInt();
        }

        // 0 : 공동 1등, 1 : A가 1등, 2 : B가 1등
        int[] board = new int[N + 1];
        int scoreA = 0, scoreB = 0;

        for (int i = 0; i < N; i++) {
            // player[i], score[i]
            if (player[i] == 'A') {
                scoreA += score[i];
            } else {
                scoreB += score[i];
            }

            if (scoreA > scoreB) {
                board[i+1] = 1;
            } else if (scoreA < scoreB) {
                board[i+1] = 2;
            } else {
                board[i+1] = 0;
            }
        }

        // System.out.println("board : " + Arrays.toString(board));

        int lastVal = 0;
        int cnt = 0;
        for (int i = 1; i < board.length; i++) {
            // board[i]
            if (board[i] != lastVal) {
                cnt++;
            }
            lastVal = board[i];
        }

        System.out.println(cnt);
    }
}