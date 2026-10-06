import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        
        boolean flag = false;
        int lastIdx = -1;
        int seg = 0;
        for (int i = 0; i < n; i++) {
            if (flag == false && a.charAt(i) != b.charAt(i)) {
                lastIdx = i;
                flag = true;
            }

            if (flag == true && a.charAt(i) == b.charAt(i)) {
                // lastIdx ~ i - 1이 구간의 길이
                int dist = i - lastIdx;
                seg += (dist / 4);
                if (dist % 4 > 0) seg += 1;
                flag = false;
            }
        }

        if (a.charAt(n - 1) != b.charAt(n - 1)) {
            int dist = n - lastIdx;
            seg += (dist / 4);
            if (dist % 4 > 0) seg += 1;
        }

        System.out.print(seg);
    }
}