class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int iPos = convert(pos);
        int iop_start = convert(op_start);
        int iop_end = convert(op_end);
        int iVideo_len = convert(video_len);
        
        System.out.println(iop_start);
        System.out.println(iop_end);
        for (String cmd : commands) {
            if (iPos >= iop_start && iPos <= iop_end) {
                iPos = iop_end;
            }
            
            if ("prev".equals(cmd)) {
                iPos = Math.max(0, iPos - 10);
            } else if ("next".equals(cmd)) {
                iPos = Math.min(iVideo_len, iPos + 10);
            }
            
            if (iPos >= iop_start && iPos <= iop_end) {
                iPos = iop_end;
            }
        }
        
        String result = String.format("%02d:%02d", iPos / 60, iPos % 60);
        return result;
    }
    
    public int convert(String str) {
        String[] arr = str.split(":");
        int mm = Integer.parseInt(arr[0]);
        int ss = Integer.parseInt(arr[1]);
        
        return ss + 60 * mm;
    }
}