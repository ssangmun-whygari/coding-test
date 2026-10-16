import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int n = score.length;
        for (int i = 0; i < n; i++) {
            score[i] = score[i] * -1;
        }
        Arrays.sort(score);
        
        int ans = 0;
        int num = n / m;
        for (int i = 0; i < num; i++) {
            int minVal = Integer.MAX_VALUE;
            // [i*m ~ (i+1) * m)
            for (int j = i*m; j < (i+1)*m; j++) {
                int val = score[j] * -1;
                // System.out.println("i : " + i + ", val : " + val);
                minVal = Math.min(minVal, val);
            }
            ans += (minVal * m);
        }
        
        return ans;
    }
}