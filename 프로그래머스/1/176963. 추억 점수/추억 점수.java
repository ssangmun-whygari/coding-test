import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] score, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], score[i]);
        }
        
        List<Integer> scoreList = new ArrayList<>();
        int n = photo.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])) {
                    sum += map.get(photo[i][j]);
                }
            }
            scoreList.add(sum);
        }
        
        return scoreList.stream().mapToInt(Integer::intValue).toArray();
    }
}