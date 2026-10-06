import java.util.*;

class Segment {
    public int lo, hi; // inclusive, exclusive
    
    Segment(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }
    
    public boolean intersects(int lo, int hi) {
        int maxLo = Math.max(this.lo, lo);
        int minHi = Math.min(this.hi, hi);
        
        boolean result = maxLo < minHi;
        // System.out.println("this.lo : " + this.lo + ", this.hi : " + this.hi + ", lo : " + lo + ", hi : " + hi + ", result : " + result);
        return result;
    }
}

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int m = spoiler_ranges.length;
        String[] msg = message.split(" ");
        int n = msg.length;
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = msg[i].length();
        }
        
        Segment[] seg = new Segment[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // idx, idx + len[i]
            seg[i] = new Segment(idx, idx + len[i]);
            idx = idx + len[i] + 1;
        }
        
        boolean[] visited = new boolean[n];
        Set<String> importatnt = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int lo = spoiler_ranges[i][0];
            int hi = spoiler_ranges[i][1];
            
            for (int j = 0; j < n; j++) {
                if (seg[j].intersects(lo, hi + 1)) {
                    visited[j] = true;
                    importatnt.add(msg[j]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == false && importatnt.contains(msg[i])) {
                importatnt.remove(msg[i]);
            }
        }
        
        return importatnt.size();
    }
}