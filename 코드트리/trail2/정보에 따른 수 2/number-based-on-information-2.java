import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        int[] chars = new int[1001]; // 1 ~ 1000, 1 : S, 2 : N
        for (int i = 0; i < T; i++) {
            char SN = sc.next().charAt(0);
            if (SN == 'S') {
                chars[sc.nextInt()] = 1;
            } else {
                chars[sc.nextInt()] = 2;
            }
        }
        
        int ans = 0;
        for (int i = a; i <= b; i++) {
            // 가장 가까이 있는 S, N 찾기
            int d1 = 1000, d2 = 1000;
            for (int d = 0; d < 1000; d++) {
                if (inRange(i - d)) {
                    int c = chars[i - d];
                    if (c == 1 && d1 == 1000) {
                        d1 = d;
                    } else if (c == 2 && d2 == 1000) {
                        d2 = d;
                    }
                }
                if (inRange(i + d)) {
                    int c = chars[i + d];
                    if (c == 1 && d1 == 1000) {
                        d1 = d;
                    } else if (c == 2 && d2 == 1000) {
                        d2 = d;
                    }
                }
                if (d1 != 1000 && d2 != 1000) {
                    break; // 다 찾았음
                }
            }
            if (d1 <= d2) {
                // System.out.println("특별한 위치 : " + i);
                ans++;
            }
        }
        System.out.println(ans);


    }

    public static boolean inRange(int i) {
        return (i >= 1 && i <= 1000);
    }
}