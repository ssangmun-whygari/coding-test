class Solution {
    public int solution(int left, int right) {
        int ans = 0;
        
        for (int i = left; i <= right; i++) {
            int yaksooNum = getYaksooNum(i);
            // System.out.println("i : " + i + ", 약수의 개수 : " + yaksooNum);
            if (yaksooNum % 2 == 0) {
                ans += i;
            } else {
                ans -= i;
            }
        }
        
        return ans;
    }
    
    public int getYaksooNum(int x) {
        int cnt = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}