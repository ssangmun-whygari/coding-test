import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int p = sc.nextInt();
        char[] c = new char[M];
        int[] u = new int[M];
        for (int i = 0; i < M; i++) {
            c[i] = sc.next().charAt(0);
            u[i] = sc.nextInt();
        }
        
        boolean[] read = new boolean[N]; // 첫번째가 'A'
        for (int i = 0; i < p; i++) {
            if (u[i] == 0) {
                Arrays.fill(read, true);
                continue;
            }

            if (i > 0 && u[i] == u[i - 1]) {
                // read 초기화를 하지 않는다.
            } else {
                read = new boolean[N]; 
            }

            for (int j = i; j < M; j++) {
                read[c[j] - 'A'] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (read[i] == false) {
                System.out.print((char) ('A' + i) + " ");
            }
        }
    }
}