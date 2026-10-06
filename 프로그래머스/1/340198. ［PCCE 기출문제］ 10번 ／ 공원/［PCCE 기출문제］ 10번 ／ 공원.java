class Solution {
    public int solution(int[] mats, String[][] park) {
        int ans = -1;
        int m = park.length;
        int n = park[0].length;
        
        for (int i : mats) {
            boolean possible = false;
            
            for (int j = 0; j <= m - i; j++) {
                if (possible) break;
                for (int k = 0; k <= n - i; k++) {
                    if (possible) break;
                    
                    boolean p = true;
                    for (int x = j; x < j + i; x++) {
                        for (int y = k; y < k + i; y++) {
                            if (!"-1".equals(park[x][y])) {
                                p = false;
                            }
                        }
                    }
                    if (p == true) {
                        possible = true;
                    }
                }
            }
            
            if (possible) {
                // System.out.println("mat : " + i);
                ans = Math.max(ans, i);
            }
        }
        
        return ans;
    }
}