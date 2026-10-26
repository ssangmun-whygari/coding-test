import java.util.regex.*;
import java.util.*;

class Result {
    public int n;
    public Character SDT;
    public Character option;

    Result(int n, Character SDT, Character option) {
        this.n = n;
        this.SDT = SDT;
        this.option = option;
    }
    
    @Override
    public String toString() {
        return "[" + n + ", \'" + SDT + "\', " + option + "]";
    }
}

class Solution {
    public int solution(String dartResult) {
        List<Result> list = new ArrayList<>();
        
        Pattern pattern = Pattern.compile("([0-9]+)([A-Z])([*#])?");
        Matcher matcher = pattern.matcher(dartResult);
        while (matcher.find()) {
            int n = Integer.parseInt(matcher.group(1));
            Character SDT = matcher.group(2).charAt(0);
            Character option = (matcher.group(3) != null) ? matcher.group(3).charAt(0) : null;
            list.add(new Result(n, SDT, option));
        }
        // System.out.println("list : " + list);
        
        int[] mapper = new int[128];
        mapper['S'] = 1;
        mapper['D'] = 2;
        mapper['T'] = 3;
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = list.get(i).n;
            result[i] = square(result[i], mapper[list.get(i).SDT]);
        }
        // System.out.println("result : " + Arrays.toString(result));
        for (int i = 0; i < 3; i++) {
            Character option = list.get(i).option;
            if (option == null) continue;
            if (option.equals('*')) {
                result[i] *= 2;
                if (i > 0) result[i - 1] *= 2;
            } else if (option.equals('#')) {
                result[i] *= -1;
            }
        }
        return Arrays.stream(result).sum();
    }
    
    public int square(int n, int k) {
        int result = 1;
        while (k-- > 0) {
            result *= n;
        }
        return result;
    }
    
}