import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];
        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
        }
        
        int maxLoad = 0;
        for (int t = -1; t <= 1001; t++) {
            int load = 0;
            for (int i = 0; i < n; i++) {
                if (t < ta[i]) {
                    load += c;
                } else if (t <= tb[i]) {
                    load += g;
                } else {
                    load += h;
                }
            }
            maxLoad = Math.max(maxLoad, load);
        }

        System.out.println(maxLoad);
    }
}