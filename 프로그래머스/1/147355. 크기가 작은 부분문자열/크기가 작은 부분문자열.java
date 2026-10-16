class Solution {
    public int solution(String t, String p) {
        int n = p.length();
        
        int cnt = 0;
        for (int i = 0; i <= t.length() - n; i++) {
            long x = Long.parseLong(t.substring(i, i + n));
            long y = Long.parseLong(p);
            // System.out.println("x : " + x + ", y : " + y);
            if (x <= y) {
                cnt++;
            }
        }
        
        return cnt;
    }
}