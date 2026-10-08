import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            int minW = Math.min(wallet[0], wallet[1]);
            int minB = Math.min(bill[0], bill[1]);
            int maxW = Math.max(wallet[0], wallet[1]);
            int maxB = Math.max(bill[0], bill[1]);
            if (minW >= minB && maxW >= maxB) {
                break;
            }
            
            answer++;
            if (bill[0] < bill[1]) {
                bill[1] /= 2;
            } else {
                bill[0] /= 2;
            }
        }
        
        return answer;
    }
}