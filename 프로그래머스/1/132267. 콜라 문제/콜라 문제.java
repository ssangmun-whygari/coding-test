class Solution {
    public int solution(int a, int b, int n) {
        int cnt = 0;
        
        while (n >= a) {            
            int new_cola = (n / a) * b;
            cnt += new_cola; // 상점에서 주는 새 콜라
            n = n % a; // 상점에 넘겨주지 않은 빈 병
            n += new_cola; // 새 콜라 -> 빈 콜라
        }
        
        return cnt;
    }
}