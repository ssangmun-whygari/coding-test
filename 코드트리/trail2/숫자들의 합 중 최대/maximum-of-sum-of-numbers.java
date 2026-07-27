import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(), Y = sc.nextInt();
        
        int maxSum = 0;
        for (int i = X; i <= Y; i++) {
            int d0 = i / 10000;
            int d1 = (i % 10000) / 1000;
            int d2 = (i % 1000) / 100;
            int d3 = (i % 100) / 10;
            int d4 = i % 10;
            maxSum = Math.max(maxSum, d0 + d1 + d2 + d3 + d4);
        }
        System.out.println(maxSum);
    }
}