import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        int ans = 0;
        int i = 0; // a를 곱한 횟수
        while ((i++) * a <= c) {
            int j = 0; // b를 곱한 횟수
            while (i * a + j * b <= c) {
                j++;
            }
            j = j - 1; // 마지막으로 c 이하인 j
            int cand = i * a + j * b;
            ans = Math.max(ans, cand);
        }

        System.out.println(ans);
    }
}