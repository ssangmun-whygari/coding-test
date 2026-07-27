import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    boolean overlap = false;
                    boolean[] exists = new boolean[101];
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) continue;
                        // a[l], b[l]
                        for (int m = a[l]; m <= b[l]; m++) {
                            if (!exists[m]) {
                                exists[m] = true;
                            } else {
                                // 겹침
                                overlap = true;
                                break;
                            }
                        }
                        if (overlap) break;
                    }
                    if (!overlap) {
                        // System.out.println("i : " + (i + 1) + ",j : " + (j + 1) + ",k : " + (k + 1));
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}