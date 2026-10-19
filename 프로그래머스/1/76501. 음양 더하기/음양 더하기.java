class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int n = signs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (signs[i] == true ? 1 : -1) * absolutes[i];
        }
        return ans;
    }
}