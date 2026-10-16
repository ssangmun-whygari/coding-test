import java.util.*;

class Solution {
    public int solution(int[] arr) {
        // 1 - 2 - 3 - 1
        
        // 2 - 1 - 1 - 2 - 3 - 1 - 2 - 3 - 1
        
        // 2 - 1 - (1 - 2 - 3 - 1) - 2 - 3 - 1
        int n = arr.length;
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(arr[i]);
            if (stack.size() >= 4) {
                boolean result = check_stack(stack);
                if (result) cnt++;
            }
        }
        
        return cnt;
    }
    
    public boolean check_stack(Stack<Integer> stack) {
        int a = stack.pop();
        int b = stack.pop();
        int c = stack.pop();
        int d = stack.pop();
        
        if (a == 1 && b == 3 && c == 2 && d == 1) {
            return true;
        }
        
        stack.add(d);
        stack.add(c);
        stack.add(b);
        stack.add(a);
        return false;
    }
}