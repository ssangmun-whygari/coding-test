import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt(), c= sc.nextInt(), d = sc.nextInt();

        int ans = 0;
        int overlapped = 0;

        ans += (b - a);
        ans += (d-  c);

        if (b <= c || d <= a) { // 겹치지 않음
            // 
        } else if (a <= c && c <= b) {
            overlapped += (Math.min(b, d) - c);
        } else if (a <= d && d <= b) {
            overlapped += (d - Math.max(a, c));
        } else if (c <= a && a <= d) {
            overlapped += (Math.min(b, d) - a);
        } else if (c <= b && b <= d) {
            overlapped += (Math.max(a, c) - b);
        }
        ans -= overlapped;

        System.out.println(ans);
    }
}