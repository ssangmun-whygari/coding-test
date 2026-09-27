import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        
        long left = 1;
        long right = 2_000_000_000;

        long ans = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (f(mid) >= n) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }
    
    // x가 볓번째 숫자인가?를 반환하는 함수
    public static long f(long x) {
        long cnt = 0; // x 이하의 3이나 5의 배수의 개수
        cnt += (x / 3);
        cnt += (x / 5);
        cnt -= (x / 15);
        return x - cnt;
    }

    // public static boolean isMoo(long x) {
    //     return (x / 3 == 0) || (x / 5 == 0);
    // }
}