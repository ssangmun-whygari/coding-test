import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        
        long sum = Arrays.stream(arr).sum();
        if (sum % 4 > 0) {
            System.out.print(0);
            System.exit(0);
        }
        // System.out.println(sum);

        long[] L = new long[n];
        L[0] = arr[0];
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] + arr[i];
        }
        long[] R = new long[n];
        R[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] + arr[i];
        }

        int[] quarterL = new int[n];
        int endL = 0;
        for (int i = 0; i < n; i++) {
            if (L[i] == sum / 4) {
                quarterL[endL++] = i;
            }
        }
        int[] quarterR = new int[n];
        int endR = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (R[i] == sum / 4) {
                quarterR[endR--] = i;
            }
        }

        int leftCnt = 0, rightCnt = 0;
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (L[i] == sum / 2) {
                // 0 ~ i을 균등한 구간으로 나눠야 함
                leftCnt = lb(quarterL, endL - 1, i - 1) + 1;

                // i + 1 ~ n - 1을 균등한 구간으로 나눠야 함
                // 구간의 길이 : n - i - 1
                rightCnt = n - 1 - (lb2(quarterR, endR + 1, i + 2)) + 1;

                if (leftCnt < 0 || rightCnt < 0) {
                    throw new RuntimeException("예상 외 계산 결과");
                }

                ans += (leftCnt * rightCnt);
            }
        }
        System.out.print(ans);
    }

    // 오름차순 배열에서 x 이상이 처음으로 등장하는 인덱스
    // 없으면 arr.length 반환
    public static int lb2(int[] arr, int start, int target) {
        int left = start;
        int right = arr.length - 1;
        int minIdx = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                minIdx = Math.min(minIdx, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

    // 오름차순 배열에서 x 이하가 마지막으로 등장하는 인덱스
    // 없으면 -1 반환
    public static int lb(int[] arr, int end, int target) {
        int left = 0;
        int right = end;
        int maxIdx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                maxIdx = Math.max(mid, maxIdx);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxIdx;
    }
}