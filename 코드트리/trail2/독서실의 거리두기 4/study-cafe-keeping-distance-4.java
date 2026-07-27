import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();
        
        char[] seatArr = seat.toCharArray();
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (seatArr[i] != '0' || seatArr[j] != '0') continue;
                seatArr[i] = '1'; seatArr[j] = '1';
                // 가장 가까운 거리를 계산

                int lastIdx = -1;
                int closest = Integer.MAX_VALUE; // 가장 가까운 두 사람의 거리
                for (int k = 0; k < n; k++) {
                    if (seatArr[k] == '1') {
                        if (lastIdx > -1) {
                            int dist = k - lastIdx;
                            closest = Math.min(closest, dist);
                        }
                        lastIdx = k;
                    }
                }
                ans = Math.max(ans, closest);

                seatArr[i] = '0'; seatArr[j] = '0';
            }
        }

        System.out.println(ans);
    }
}