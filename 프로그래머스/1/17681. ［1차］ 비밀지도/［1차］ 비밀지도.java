class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map1 = getMap(arr1, n);
        int[][] map2 = getMap(arr2, n);
            
        String[] answer = new String[n];
        
        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < n; x++) {
                int cell = map1[r][x] | map2[r][x];
                sb.append(cell == 1 ? '#' : ' ');
            }
            answer[r] = sb.toString();
        }
        return answer;
    }
    
    public int[][] getMap(int[] arr, int n) {
        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            int row = arr[r];
            for (int x = 0; x < n; x++) {
                int cell = (row >> x) & 1;
                map[r][n - 1 - x] = cell;
            }
        }
        return map;
    }
}