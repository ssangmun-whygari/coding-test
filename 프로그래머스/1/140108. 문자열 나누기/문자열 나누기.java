class Solution {
    public int solution(String s) {
        int n = s.length();
        
        char self = s.charAt(0);
        int self_count = 1;
        int other_count = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (self_count == 0) {
                self = s.charAt(i);
            }
            
            char ch = s.charAt(i);
            if (ch == self) {
                self_count++;
            } else {
                other_count++;
            }
            
            if (self_count == other_count) {
                self_count = 0;
                other_count = 0;
                // System.out.println("i : " + i + ", self : " + self);
                if (i != n - 1) ans++;
            }
        }
        
        return ans + 1;
    }
}