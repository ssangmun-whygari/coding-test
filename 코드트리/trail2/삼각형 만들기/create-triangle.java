import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int hori = getHori(x[i], x[j], x[k], y[i], y[j], y[k]);
                    int vert = getVert(x[i], x[j], x[k], y[i], y[j], y[k]);
                    int area;
                    if (hori != -1 && vert != -1) {
                        area = hori * vert;
                        maxArea = Math.max(maxArea, area);
                    } 
                }
            }
        }
        System.out.println(maxArea);
    }

    public static int getHori(int x0, int x1, int x2, int y0, int y1, int y2) {
        if (y0 == y1 && y1 != y2) {
            return Math.abs(x0 - x1);
        } else if (y1 == y2 && y0 != y1) {
            return Math.abs(x1 - x2);
        } else if (y0 == y2 && y0 != y1) {
            return Math.abs(x0 - x2);
        } else {
            return -1;
        }
    }

    public static int getVert(int x0, int x1, int x2, int y0, int y1, int y2) {
        if (x0 == x1 && x1 != x2) {
            return Math.abs(y0 - y1);
        } else if (x1 == x2 && x0 != x1) {
            return Math.abs(y1 - y2);
        } else if (x0 == x2 && x0 != x1) {
            return Math.abs(y0 - y2);
        } else {
            return -1;
        }
    }
}