import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        int firstOccupied = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == '1') {
                firstOccupied = i;
                break;
            }
        }
        int lastOccupied = N - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                lastOccupied = i;
                break;
            }
        }

        int lastIdx = firstOccupied;
        int low = firstOccupied;
        int high = lastOccupied;
        int maxDiff = 0;
        for (int i = firstOccupied; i <= lastOccupied; i++) {
            if (arr[i] == '1') {
                int diff = i - lastIdx;
                if (diff > maxDiff) {
                    maxDiff = diff;
                    low = lastIdx;
                    high = i;
                }
                lastIdx = i;
            }
        }
        // System.out.println("low: " + low + ",high: " + high + ",maxDiff: " + maxDiff);

        // 중간에 1을 위치한 경우
        int maxDist = 0;
        char temp = arr[(low + high) / 2];
        arr[(low + high) / 2] = '1';
        // System.out.println("arr : " + String.valueOf(arr));
        maxDist = Math.max(maxDist, getMinDist(arr));
        arr[(low + high) / 2] = temp;

        // 처음이나 끝에 1을 위치한 경우
        if (arr[0] == '0') {
            arr[0] = '1';
            // System.out.println("arr : " + String.valueOf(arr));
            maxDist = Math.max(maxDist, getMinDist(arr));
            arr[0] = '0';
        }

        if (arr[N - 1] == '0') {
            arr[N - 1] = '1';
            // System.out.println("arr : " + String.valueOf(arr));
            maxDist = Math.max(maxDist, getMinDist(arr));
            arr[N - 1] = '0';
        }

        System.out.println(maxDist);
    }

    public static int getMinDist(char[] arr) {
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == '1' && arr[j] == '1') {
                    minDist = Math.min(j - i, minDist);
                    break;
                }
            }
        }
        if (minDist == Integer.MAX_VALUE) return 0;
        return minDist;
    }
}