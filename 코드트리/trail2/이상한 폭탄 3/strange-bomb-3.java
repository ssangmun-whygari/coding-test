import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++)
            bombs[i] = sc.nextInt();

        // 몇번째 폭탄이 폭발했는가?
        boolean[] explode = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i > k) continue;
                if (bombs[i] == bombs[j]) {
                    explode[i] = true;
                    explode[j] = true;
                }
            }
        }

        // 어떤 숫자가 몇 번 폭발했는가?
        int[] explodeNum = new int[1000001];
        for (int i = 0; i < n; i++) {
            if (explode[i]) {
                explodeNum[bombs[i]]++;
            }
        }
        
        int maxIdx = 0;
        int maxVal = 0;
        for (int i = 0; i < explodeNum.length; i++) {
            if (explodeNum[i] > maxVal) {
                maxVal = explodeNum[i];
                maxIdx = i;
            }
        }

        System.out.println(maxIdx);
    }
}