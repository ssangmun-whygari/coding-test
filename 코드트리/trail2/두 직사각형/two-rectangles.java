import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
        int a1 = sc.nextInt(), b1 = sc.nextInt(), a2 = sc.nextInt(), b2 = sc.nextInt();

        if (x2 < a1 || a2 < x1 || y2 < b1 || b2 < y1) {
            System.out.println("nonoverlapping");
        } else {
            System.out.println("overlapping");
        }
    }
}