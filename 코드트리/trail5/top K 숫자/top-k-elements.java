import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        StringBuilder sb = new StringBuilder();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }

        while (k-- > 0) {
            Integer last = set.last();
            sb.append(last + " ");
            set.remove(last);
        }
        System.out.print(sb.toString());
    }
}