import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            set.add(arr1[i]);
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(set.contains(arr2[i]) ? 1 : 0);
            sb.append(' ');
        }
        System.out.print(sb.toString());
    }
}