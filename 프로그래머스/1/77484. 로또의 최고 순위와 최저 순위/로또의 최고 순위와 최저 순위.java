import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int x = 0; // 맞춘 개수
        int y = 0; // 확실하게 틀린 개수
        
        Set<Integer> win_set = new HashSet<>();
        for (int i : win_nums) {
            win_set.add(i);
        }
    
        for (int i : lottos) {
            if (win_set.contains(i)) {
                x++;
            } else if (i != 0) {
                y++;   
            }
        }
        
        int min = x;
        int max = 6 - y;
        return new int[] {Math.min(7 - max, 6), Math.min(7 - min, 6)};
    }
}