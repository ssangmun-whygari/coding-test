import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] groups = new int[n];

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int bitmask = 0;
            for (int j = 0; j < m; j++) {
                int person = sc.nextInt();
                bitmask |= (1 << person);
            }
            groups[i] = bitmask;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[i] + groups[j] == (groups[i] | groups[j]) ) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}