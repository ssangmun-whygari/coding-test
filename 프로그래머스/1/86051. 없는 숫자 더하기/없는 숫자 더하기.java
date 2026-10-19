class Solution {
    public int solution(int[] numbers) {
        boolean[] exist = new boolean[10]; // 0 ~ 9
        for (int i : numbers) {
            exist[i] = true;
        }
        
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            if (exist[i] == false) {
                ans += i;
            }
        }
        
        return ans;
    }
}