import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.valueOf(sc.nextInt());
        }

        Arrays.sort(arr, (n1, n2) -> {
            String s1 = n1 + "" + n2;
            String s2 = n2 + "" + n1;

            // s1 > s2면 앞으로 와야 함
            return Long.valueOf(s2).compareTo(Long.valueOf(s1));
        });

        // System.out.print(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        for (Long i : arr) {
            sb.append(i);
        }
        System.out.print(sb.toString());
    }
}