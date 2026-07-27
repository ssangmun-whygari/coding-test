import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] selected = new boolean[6];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            selected[i] = true;
            for (int j = 0; j < 6; j++) {
                if (selected[j] == true) continue;
                selected[j] = true;
                int sum1 = arr[i] + arr[j];
                for (int k = 0; k < 6; k++) {
                    if (selected[k] == true) continue;
                    selected[k] = true;
                    for (int l = 0; l < 6; l++) {
                        if (selected[l] == true) continue;
                        selected[l] = true;
                        int sum2 = arr[k] + arr[l];
                        for (int m = 0; m < 6; m++) {
                            if (selected[m] == true) continue;
                            selected[m] = true;
                            for (int n = 0; n < 6; n++) {
                                if (selected[n] == true) continue;
                                int sum3 = arr[m] + arr[n];
                                int diff = getDiff(sum1, sum2, sum3);
                                minDiff = Math.min(minDiff, diff);
                            }
                            selected[m] = false;
                        }
                        selected[l] = false;
                    }
                    selected[k] = false;
                }
                selected[j] = false;
            }
            selected[i] = false;
        }
        System.out.println(minDiff);
    }

    public static int getDiff(int a, int b, int c) {
        int max = ((a > b) ? a : b) > c ? ((a > b) ? a : b) : c;
        int min = ((a < b) ? a : b) < c ? ((a < b) ? a : b) : c;
        return max - min;
    }
}