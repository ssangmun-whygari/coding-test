import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 2 0 0 3 0
        // 0 0 0 3 2
        
        // 2 0 0 3 0
        // 0 0 0 3 2 : 2명이 4칸 이동

        // 2 0 0 3 0
        // 2 0 0 1 2 : 2명이 1칸 이동

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }

        int distSum = 0;
        for (int i = N - 1; i >= 0; i--) {
            int x = arr2[i] - arr1[i]; // 남은 양

            for (int j = i - 1; j >= 0; j--) {
                int dist = i - j;
                if (arr1[j] >= x) {
                    arr1[j] -= x; // j에서 i로 이동
                    arr1[i] += x;
                    distSum += (dist * x);
                    x = 0;
                    break;
                } else {
                    // arr1[j] < x
                    arr1[i] += arr1[j]; // j에서 i로 이동
                    x -= arr1[j];
                    distSum += (dist * arr1[j]);
                    arr1[j] = 0;
                }
            }
        }

        System.out.println(distSum);
    }
}