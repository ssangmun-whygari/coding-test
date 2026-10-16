import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        // m : 롤러의 길이, n : 벽의 길이
        
        boolean[] wall = new boolean[n];
        
        for (int i : section) {
            wall[i - 1] = true; // 색을 다시 칠해야 함
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (wall[i] == true) {
                paint(wall, i, m, n);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public void paint(boolean[] wall, int start, int m, int n) {
        // System.out.println("start : " + start + ", m : " + m + ", n : " + n);
        for (int i = start; i < Math.min(n, start + m); i++) {
            wall[i] = false;
        }
    }
}