import java.util.*;

class Solution {
    public int m, n;
    
    public int[] solution(String[] park, String[] routes) {
        m = park.length;
        n = park[0].length();
        
        int x = 0, y = 0; // 강아지의 시작 좌표
        
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] row = park[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (row[j] == 'S') {
                    x = i; y = j; // 시작 좌표 설정
                }
                grid[i][j] = row[j];
            }
        }

        List<String> dir = Arrays.asList(new String[] {"N", "S", "W", "E"});
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        
        for (String cmd : routes) {
            String[] params = cmd.split(" ");
            int d = dir.indexOf(params[0]); // 0, 1, 2, 3
            int dist = Integer.parseInt(params[1]);
            boolean possible = true;
            int nx = x, ny = y;
            for (int i = 1; i <= dist; i++) {
                nx = x + dx[d] * i;
                ny = y + dy[d] * i;
                if (!canGo(nx, ny, grid)) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                x = nx;
                y = ny;
            }
        }
        
        return new int[] {x, y};
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    
    public boolean canGo(int x, int y, char[][] grid) {
        return inRange(x, y) && grid[x][y] != 'X';
    }
}