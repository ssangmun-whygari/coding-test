import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] ans = new int[set.size()];
        int k = 0;
        for (int i : set) {
            ans[k++] = i;
        }
        Arrays.sort(ans);
        
        return ans;
    }
}