import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {        
        int[] yaksoo = new int[number]; // 1 ~ number
        for (int i = 0; i < number; i++) {
            yaksoo[i] = get_yaksoo_num(i + 1);
        }
        // System.out.println("yaksoo : " + Arrays.toString(yaksoo));
        
        int result = 0;
        for (int i : yaksoo) {
            if (i > limit) {
                result += power;
            } else {
                result += i;
            }
        }
        return result;
    }
    
    public int get_yaksoo_num(int n) {
        int k = (int) Math.sqrt(n);
        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    cnt++;
                } else {
                    cnt = cnt + 2;
                }
            }
        }
        return cnt;
    }
}