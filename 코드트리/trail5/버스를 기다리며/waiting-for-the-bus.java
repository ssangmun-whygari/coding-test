import java.util.*;
public class Main {
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        int c = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        Arrays.sort(t);

        int left = 0;
        int right = (int) 1e9;
        int ans = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (is_possible(mid, t, c)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }

    public static boolean is_possible(int limit, int[] t, int capacity) {
        // limit까지 기다릴 수 있을때 버스에 인원을 모두 태우는 것이 가능한가?
        int lastPerson = 0;
        int c = 0; // 버스에 탈 사람 수
        int busCnt = 0;
        for (int i = 0; i < t.length; i++) {
            // t[lastPerson], t[i]
            if (t[i] - t[lastPerson] <= limit && c < capacity) {
                c++;
            } else {
                busCnt++; // lastPerson ~ i - 1를 버스에 태움
                lastPerson = i;
                c = 1;
            }
        }
        if (c > 0) busCnt++;

        return busCnt <= m;
    }
}