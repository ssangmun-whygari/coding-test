class Solution {
    public int[] solution(String[] wallpaper) {
        int m = wallpaper.length;
        int n = wallpaper[0].length();
        char[][] grid = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            grid[i] = wallpaper[i].toCharArray();
        }
        
        // 총 파일 개수 찾기
        int fileCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    fileCnt++;
                }
            }
        }
        // System.out.println("fileCnt : " + fileCnt);
        
        int minLength = Integer.MAX_VALUE;
        int[] ans = new int[4];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < m; k++) {
                    for (int l = j; l < n; l++) {
                        if (includeAll(fileCnt, grid, i, j, k, l)) {
                            int length = (k + 1 - i) + (l + 1 - j);
                            if (length < minLength) {
                                ans[0] = i; ans[1] = j; ans[2] = k + 1; ans[3] = l + 1;
                                minLength = length;
                            }
                        } // if_end
                    }
                }
            }
        }
        
        return ans;
    }
    
    public boolean includeAll(int fileCnt, char[][] grid, int sx, int sy, int ex, int ey) {
        int cnt = 0;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                if (grid[i][j] == '#') {
                    cnt += 1;
                }
            }
        }
        return cnt == fileCnt;
    }
}