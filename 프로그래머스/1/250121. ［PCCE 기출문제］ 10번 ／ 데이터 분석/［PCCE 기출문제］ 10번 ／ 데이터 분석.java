import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int n = data.length;
        List<int[]> list = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        
        // filter
        for (int i = 0; i < n; i++) {
            int[] row = data[i];
            int idx = map.get(ext);
            if (row[idx] < val_ext) {
                list.add(row);
            }
        }
        
        // bubble_sort
        int m = list.size();
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - 1 - i; j++) {
                int idx = map.get(sort_by);
                int[] a = list.get(j);
                int[] b = list.get(j + 1);
                if (a[idx] > b[idx]) { // 크면 뒤로 보낸다.
                    swap(j, j + 1, list);    
                }
            }
        }
        
        int[][] answer = new int[m][4];
        for (int i = 0; i < m; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void swap(int i, int j, List<int[]> list) {
        int[] temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}