import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != b[i]) {
                cnt++;
                invert(a, i);
            }
        }

        System.out.print(cnt);
    }

    public static void invert(char[] a, int k) {
        // 인덱스 k 이하의 요소들을 반전시킨다.
        for (int i = 0; i <= k; i++) {
            a[i] = (a[i] == 'G') ? 'H' : 'G';
        }
    }
}