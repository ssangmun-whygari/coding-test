class Solution {
    public String solution(int[] food) {
        int n = food.length;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            // food[i]
            if (food[i] % 2 == 1) {
                food[i] -= 1;
            }
            
            for (int j = 0; j < (food[i] / 2); j++) {
                sb.append(i);
            }
        }
        
        return sb.toString() + "0" + sb.reverse().toString();
    }
}