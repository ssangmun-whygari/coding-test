import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[101]; // 0 ~ 100

        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);
            if (ch == 'G') {
                arr[position] = 1;
            } else {
                arr[position] = 2;
            }
        }
        
        int maxSize = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                // 양쪽 끝은 항상 사람이어야 한다.
                if (arr[i] == 0 || arr[j] == 0) continue;
                // [i, j]구간의 사진 크기는 j - i - 1
                int size = j - i;
                int numG = 0, numH = 0;
                for (int k = i; k <= j; k++) {
                    if (arr[k] == 1) numG++;
                    else if (arr[k] == 2) numH++;
                }
                if ((numG > 0 && numH == 0) || (numG == 0 && numH > 0)) {
                    maxSize = Math.max(maxSize, size);
                } else if (numG == numH && numG > 0) {
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        System.out.println(maxSize);
    }
}