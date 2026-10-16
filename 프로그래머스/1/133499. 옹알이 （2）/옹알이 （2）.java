class Solution {
    public int solution(String[] babbling) {
        int cnt = 0;
        for (String str : babbling) {
            if (baleum(str) == true) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public boolean baleum(String str) {
        int n = str.length();
        int p = 0;
        boolean possible = true;
        String last = null;
        while (p < n) {
            String cand = str.substring(p, Math.min(n, p + 2));
            if ("ye".equals(cand) || "ma".equals(cand)) {
                if (cand.equals(last)) {
                    possible = false;
                    break;
                }
                last = cand;
                
                p += 2;
                if (p == n) break;
                continue;
            }
            cand = str.substring(p, Math.min(n, p + 3));
            if ("aya".equals(cand) || "woo".equals(cand)) {
                if (cand.equals(last)) {
                    possible = false;
                    break;
                }
                last = cand;
                
                p += 3;
                if (p == n) break;
                continue;
            }
            
            possible = false;
            break;
        }
        // System.out.println("str : " + str + ", possible : " + possible);
        return possible;
    }
}