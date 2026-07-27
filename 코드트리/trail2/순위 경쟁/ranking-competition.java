import java.util.*;

public class Main {
    public static int leader = 7; // 111(2)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] score = new int[3]; // 0, 0, 0;

        int ans = 0;
        for (int i = 0; i < N; i++) {
            char who = sc.next().charAt(0);
            int s = sc.nextInt();
            if (simulate(score, who, s)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static boolean simulate(int[] score, char who, int s) {
        score[who - 'A'] += s;

        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < score.length; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }

        int l = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                l += (1 << i);
            }
        }

        if (leader != l) {
            leader = l;
            return true; // 바뀜
        } else {
            leader = l;
            return false; // 안바뀜
        }
    }
}