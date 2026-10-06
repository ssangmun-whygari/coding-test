import java.util.*;

class Solution {
    public static int MAX_T = (int) Math.pow(20, 5);
    // public static int MAX_T = 20;
    
    public int solution(int[][] signals) {
        int answer = -1;
        int n = signals.length;
        
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = Arrays.stream(signals[i]).sum();
        }
        // System.out.println(isYellow(new int[] {2, 3, 2}, 7, 10));
        
        for (int t = 1; t <= MAX_T; t++) {
            boolean allYellow = true;
            for (int i = 0; i < n; i++) {
                if (!isYellow(signals[i], sum[i], t)) {
                    allYellow = false;
                }
            }
            if (allYellow) {
                answer = t;
                break;
            }
        }
        
        return answer;
    }
    
    public boolean isYellow(int[] arr, int sum, int t) {
        // System.out.println("arr : "  + Arrays.toString(arr) + ", sum : " + sum + ", t : " + t);
        int lo = arr[0] % sum;
        int hi = (arr[0] + arr[1]) % sum;
        t = t % sum;
        // System.out.println("lo : " + lo + ", hi : " + hi);
        return lo < t && t <= hi;
    }
}