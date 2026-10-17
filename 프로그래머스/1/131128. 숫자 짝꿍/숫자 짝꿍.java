class Solution {
    public String solution(String X, String Y) {
        
        int[] x = new int[10]; // 0 ~ 9
        int[] y = new int[10];
        
        int m = X.length();
        int n = Y.length();
        
        for (int i = 0; i < m; i++) {
            int digit = X.charAt(i) - '0';
            x[digit] += 1;
        }
        for (int i = 0; i < n; i++) {
            int digit = Y.charAt(i) - '0';
            y[digit] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean allZero = true;
        for (int i = 9; i >= 0; i--) {
            if (x[i] > 0 && y[i] > 0) {
                if (i > 0) allZero = false;
                int num = Math.min(x[i], y[i]);
                while (num-- > 0) {
                    sb.append(i);
                }
            }
        }
        
        String ans = sb.toString();
        if (ans.length() == 0) {
            ans = "-1";
        } else if (allZero) {
            ans = "0";
        }
        
        return ans;
    }
}