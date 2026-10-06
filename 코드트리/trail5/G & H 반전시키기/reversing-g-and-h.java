import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        
        int seg = 0;
        for (int i = 0; i < n - 1; i++) {
            // a.charAt(i), b.charAt(i)
            // a.charAt(i + 1), b.charAt(i + 1)
            if (a.charAt(i) != b.charAt(i) && a.charAt(i + 1) == b.charAt(i + 1)) {
                seg++;
            }
        }
        if (a.charAt(n - 1) != b.charAt(n - 1)) {
            seg++;
        }
        // System.out.println("seg : " + seg);
        System.out.print(seg);
    }
}