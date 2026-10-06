class Solution {
    // 0 -> 5, 12 ...
    // 1 -> 4, 11 ...
    
    // x -> 5 - x
    // x -> (7 + (5 - x)) % 7
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        startday -= 1; // 월, 화, 수, 목, 금, 토, 일 = 0, 1, 2, 3, 4, 5, 6
        
        int n = schedules.length;
        int m = timelogs[0].length;
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean possible = true;
            for (int day = 0; day < m; day++) {
                if (!isWeekend(startday, day)) {
                    if (timelogs[i][day] > plus(schedules[i])) {
                        possible = false;
                    }
                }
            }
            if (possible) cnt++;
        }
        
        return cnt;
    }
    
    public boolean isWeekend(int startday, int day) {
        // 예) 월요일(startday = 0)이면 5, 12...일이 토요일임
        boolean isSat = day % 7 == (12 - startday) % 7;
        boolean isSun = day % 7 == (13 - startday) % 7;
        
        return isSat || isSun;
    }
    
    public int plus(int time) {
        int hh = time / 100;
        int mm = time % 100;
        
        mm = mm + 10;
        if (mm >= 60) {
            mm -= 60;
            hh += 1;
        }
        
        int result = 100 * hh + mm;
        return result;
    }
}