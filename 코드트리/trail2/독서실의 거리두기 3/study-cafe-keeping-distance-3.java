import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        int maxIdx = 0;
        int maxVal = 0;
        int lastIdx = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == '1') {
                int dist = i - lastIdx;
                if (maxVal < dist) {
                    maxVal = dist;
                    maxIdx = lastIdx;
                }
                lastIdx = i;
            }
        }

        // maxIdx와 그 다음 인덱스 사이에 1을 넣는다.
        int nextIdx = 0;
        for (int i = maxIdx + 1; i < N; i++) {
            if (arr[i] == '1') {
                nextIdx = i;
                break;
            }
        }
        // System.out.println("maxIdx : " + maxIdx + ",nextIdx : " + nextIdx);
        arr[(maxIdx + nextIdx) / 2] = '1';
        // System.out.println("arr : " + Arrays.toString(arr));

        // 가장 가까운 사람의 거리를 계산한다
        lastIdx = 0;
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            if (arr[i] == '1') {
                // System.out.println("lastIdx : " + lastIdx + ", i : " + i);
                int dist = i - lastIdx;
                // System.out.println(dist);
                minDist = Math.min(minDist, dist);
                lastIdx = i;
            }
        }

        System.out.println(minDist);
    }
}