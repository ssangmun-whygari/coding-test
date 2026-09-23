import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fires = new int[n];
        int[] stations = new int[m];
        for (int i = 0; i < n; i++)
            fires[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            stations[i] = sc.nextInt();

        Arrays.sort(fires);
        Arrays.sort(stations);

        int j = -1; // 소방서 위치
        int minLen = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < m && Math.abs(stations[j + 1] - fires[i]) < minLen) {
                minLen = Math.abs(stations[j + 1] - fires[i]);
                j++;
            }

            ans = Math.max(ans, minLen);

            if (i + 1 < n) {
                minLen = Math.abs(stations[j] - fires[i + 1]); // 새로운 기준점이 됨
            }
        }

        System.out.print(ans);
    }
}