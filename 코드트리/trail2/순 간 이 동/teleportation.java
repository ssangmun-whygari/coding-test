import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt(), B = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();

        // A -> B, A -> x -> y -> B, A -> y -> x -> B

        int minDist = Math.abs(A - B);

        int dist1 = Math.abs(A - x) + Math.abs(y - B);
        minDist = Math.min(minDist, dist1);
        int dist2 = Math.abs(A - y) + Math.abs(x - B);
        minDist = Math.min(minDist, dist2);

        System.out.println(minDist);
    }
}