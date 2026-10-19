import java.util.*;

class Solution {
    public int solution(int n, int[] l, int[] r) {
        
        Set<Integer> reserved = new HashSet<>();
        Set<Integer> lost = new HashSet<>();
        for (int i : l) {
            lost.add(i);
        }
        
        for (int i : r) {
            reserved.add(i);
        }
        for (int i : l) {
            if (reserved.contains(i)) {
                reserved.remove(i);
                lost.remove(i);
            }
        }
        
        List<Integer> list = new ArrayList<>(lost);
        Collections.sort(list);
        
        int cnt = 0;
        for (int i : list) {
            if (reserved.contains(i - 1)) {
                reserved.remove(i - 1);
                cnt++;
            } else if (reserved.contains(i + 1)) {
                reserved.remove(i + 1);
                cnt++;
            }
        }
        
        return n - (list.size() - cnt);
    }
}