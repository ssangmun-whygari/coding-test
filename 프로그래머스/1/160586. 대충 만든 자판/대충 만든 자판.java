import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int n = keymap.length;
        
        int[] mapper = new int[128];
        Arrays.fill(mapper, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            String str = keymap[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                mapper[c] = Math.min(mapper[c], j + 1);
            }
        }
        
        // for (int i = 0; i < 26; i++) {
        //     if (mapper['A' + i] < Integer.MAX_VALUE) {
        //         System.out.println((char)('A' + i) + " : " + mapper['A' + i]);
        //     }
        // }
        
        int m = targets.length;
        int[] ans = new int[m];
        
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            boolean possible = true;
            for (int j = 0; j < targets[i].length(); j++) {
                int charCnt = mapper[targets[i].charAt(j)];
                if (charCnt == Integer.MAX_VALUE) {
                    possible = false;
                } else {
                    cnt += charCnt;
                }
            }
            ans[i] = possible ? cnt : -1;
        }
        
        return ans;
    }
}