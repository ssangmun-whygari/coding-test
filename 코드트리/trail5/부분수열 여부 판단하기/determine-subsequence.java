import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        
        boolean possible = true;
        int i = 0;
        for (int j = 0; j < m; j++) {
            while (i < n && A[i] != B[j]) {
                i++;
            }

            if (i >= n) {
                possible = false;
                break;
            } else {
                i++;
            }
        }

        System.out.print(possible == true ? "Yes" : "No");
    }
}