class Solution {
    public int solution(int n, int w, int num) {        
        int[][] box = new int[100][w];
        
        // w = 3
        // i / w = 0, 1, 2, 3, ...
        // (i / w) % 2
        for (int i = 0; i < n; i++) {
            if (i / w % 2 == 0) { // 정방향
                // i % w
                box[i / w][i % w] = i + 1;
            } else { // 역방향
                box[i / w][(w - 1) - (i % w)] = i + 1;
            }
        }
        
        int sr = 0;
        int sc = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < w; j++) {
                if (box[i][j] == num) {
                    sr = i; sc = j;
                    break;
                }
            }
        }
        
        int cnt = 0;
        int r = sr;
        int c = sc;
        while (r < 100 && box[r][c] > 0) {
            r++;
            cnt++;
        }
        
        return cnt;
    }
}