import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100_000;
        int left = 1;
        int right = 100_000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (solve(mid, limit, diffs, times) == true) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    
    public boolean solve(int level, long limit, int[] diffs, int[] times) {
        long total_time = 0;
        int time_prev = 0;
        int time_cur = 0;
        boolean result = true;
        
        for (int i = 0; i < diffs.length; i++) {
            if (i == 0) {
                total_time += times[i];
            } else {
                time_cur = times[i];
                time_prev = times[i - 1];
                if (diffs[i] <= level) {
                    // time_cur만 쓰고 해결 가능
                    total_time += time_cur;
                } else {
                    long elapsed = (diffs[i] - level) * (time_cur + time_prev) + time_cur;
                    total_time += elapsed;
                }
            }
            
            if (total_time > limit) {
                result = false;
                break;
            }
        } // for_end
        return result;
    } // funtion_end
}