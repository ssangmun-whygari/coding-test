import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        int[][] grid = new int[n][n];
        // grid[x][y] : x가 y에게 선물을 준 횟수
        for (String str : gifts) {
            String[] params = str.split(" ");
            int x = map.get(params[0]);
            int y = map.get(params[1]);
            grid[x][y] += 1;
        }
        
        int[] pIndex = new int[n]; // pIndex : x번 친구의 선물 지수
        for (int i = 0; i < n; i++) {
            int give = 0; // i번 친구가 준 선물 개수
            for (int j = 0; j < n; j++) {
                give += grid[i][j];
            }
            int receive = 0;
            for (int j = 0; j < n; j++) {
                receive += grid[j][i];
            }
            pIndex[i] = give - receive;
        }
        
        int[] arr = new int[n]; // arr[x] : x번 친구가 받을 선물의 수
        for (int x = 0; x < n; x++) {
            for (int y = x; y < n; y++) {
                if (x == y) continue;
                
                if (grid[x][y] == grid[y][x]) { // 선물을 주고 받은 기록이 없거나 주고받은 수가 같으면
                    if (pIndex[x] > pIndex[y]) {
                        arr[x] += 1;
                    } else if (pIndex[x] < pIndex[y]) {
                        arr[y] += 1;
                    }
                } else if (grid[x][y] > grid[y][x]) {
                    arr[x] += 1;
                } else {
                    arr[y] += 1;
                }
            }
        }
        
        return Arrays.stream(arr).max().orElse(0);
    }
}