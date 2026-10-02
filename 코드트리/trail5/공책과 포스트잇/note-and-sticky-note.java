import java.util.*;

class Pair implements Comparable<Pair> {
    int no; // 공책 번호
    int cnt; // 적힌 횟수

    Pair(int no, int cnt) {
        this.no = no;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.cnt != other.cnt) {
            return Integer.compare(other.cnt, this.cnt); // 오름차순 정렬
        } else {
            return Integer.compare(this.no, other.no);
        }
    }
}

public class Main {
    public static int N, K, L;
    public static Pair[] pair;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        L = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        pair = new Pair[N];
        for (int i = 0; i < N; i++) {
            pair[i] = new Pair(i + 1, arr[i]);
        }
        Arrays.sort(pair);

        int left = 0;
        int right = N;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (is_possible(mid)) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }

    public static boolean is_possible(int x) {
        // h-index를 x로 만드는 게 가능한가?
        // (x 이상의 숫자를 x개 이상으로 만들어야 함)

        int xCnt = 0;
        long n = 0; // 지금까지 적은 숫자의 개수
        for (int i = 0; i < N; i++) {
            if (pair[i].cnt >= x) {
                // 이미 x 이상이라서 포스트잇에 숫자를 안 써도 된다.
                xCnt++;
            } else {
                // x - pair[i].cnt
                if (x - pair[i].cnt > K) {
                    break;
                }

                if (n + (x - pair[i].cnt) > (long) K * L) {
                    // 포스트잇이 꽉 차서 더 채울 수 없음
                    break;
                }
                n += (x - pair[i].cnt);
                xCnt++;
            }
        }

        return xCnt >= x;
    }
}