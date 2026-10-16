import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int n = score.length;
        int[] ans = new int[n];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.add(score[i]);
            } else {
                if (pq.peek() < score[i]) {
                    pq.add(score[i]);
                    pq.poll();
                }
            }
            
            ans[i] = pq.peek();
        }
        
        return ans;
    }
}