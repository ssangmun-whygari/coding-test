import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] arr = new int[128];
        int[] ans = new int[n];
        Arrays.fill(arr, -1);
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (arr[ch] == -1) {
                ans[i] = -1;
            } else {
                ans[i] = i - arr[ch];
            }
            arr[ch] = i;
        }
        
        return ans;
    }
}