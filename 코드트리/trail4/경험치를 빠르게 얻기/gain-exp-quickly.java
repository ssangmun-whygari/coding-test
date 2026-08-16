import java.util.*;

class Quest {
    int exp, time;
    Quest(int e, int t) {
        this.exp = e;
        this.time = t;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Quest[] quests = new Quest[N];
        for (int i = 0; i < N; i++) {
            quests[i] = new Quest(sc.nextInt(), sc.nextInt());
        }
        
        // dp[x] : 경험치를 x를 얻을 때 필요한 최소 시간
        int[] dp = new int[1000000 + 1]; // 0 ~ 1000000
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for (int i = 0; i < quests.length; i++) {
            // dp[j] 상태에서 가장 최근에 완료한 퀘스트가 i번째였다면?
            for (int j = 1000000; j >= 0; j--) {
                // dp[j - quests[i].exp], dp[j]
                if (j - quests[i].exp < 0) continue;
                if (dp[j - quests[i].exp] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j], dp[j - quests[i].exp] + quests[i].time);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = M; i < dp.length; i++) {
            if (dp[i] == -1) continue;
            ans = Math.min(ans, dp[i]);
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}