import java.util.*;

public class Main {
    public static void main(String[] args) {
        /// x1---x2, x3---x4
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt(), x2 = sc.nextInt(), x3 = sc.nextInt(), x4 = sc.nextInt();

        if (x3 > x2 || x1 > x4) {
            System.out.println("nonintersecting");
        } else {
            System.out.println("intersecting");
        }
    }
}