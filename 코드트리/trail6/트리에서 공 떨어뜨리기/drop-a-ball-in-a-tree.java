import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lc = new int[n + 1];
        int[] rc = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            lc[i] = sc.nextInt();
            rc[i] = sc.nextInt();
        }
        long k = sc.nextLong();
        int curNode = 1; // 루트

        while (k > 1) {
            if (lc[curNode] == -1 && rc[curNode] == -1) {
                break;
            } else if (lc[curNode] != -1 && rc[curNode] == -1) {
                curNode = lc[curNode];
            } else if (lc[curNode] == -1 && rc[curNode] != -1) {
                curNode = rc[curNode];
            } else {
                if (k % 2 == 1) {
                    // 왼쪽으로 이동
                    curNode = lc[curNode];
                    k = (k + 1) / 2;
                } else {
                    // 오른쪽으로 이동
                    curNode = rc[curNode];
                    k /= 2;
                }
            }
        }

        while (lc[curNode] != -1 || rc[curNode] != -1) {
            if (lc[curNode] != -1) { // 왼쪽이 뚫려있으면 왼쪽 우선
                curNode = lc[curNode];
            } else {
                curNode = rc[curNode];
            }
        }

        System.out.print(curNode);
    }
}