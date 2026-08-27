import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        
        Set<Integer> setA = new HashSet<>();
        for (int i : A) {
            setA.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (setA.contains(B[i])) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }
        System.out.print(sb);
    }
}