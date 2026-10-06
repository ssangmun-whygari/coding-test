class Solution {
    public int solution(int[] band, int health, int[][] attacks) {
        
        int n = attacks.length;
        int t = 0;
        int suc = 0; // 연속 성공 횟수
        int cast_t = 0; // 시전시간
        int maxHealth = health;
        for (int i = 0; i < n; i++) {
            while (t < attacks[i][0]) {
                // band[0] : 시전 시간, band[1] : 초당 회복량, band[2] : 추가 회복량
                t++;
                
                int heal = 0;
                if (++suc == band[0]) {
                    heal += band[2]; // 추가 회복
                    suc = 0;
                }
                heal += band[1];
                
                health = Math.min(maxHealth, health + heal);
                // System.out.println("t : " + t + ", health : " + health);
            }
            
            // 몬스터의 공격
            int damage = attacks[i][1];
            health = Math.max(0, health - damage);
            suc = 0;
            t++;
            // System.out.println("t : " + t + ", health : " + health);
            
            if (health == 0) {
                return -1;
            }
        }
        
        return health;
        
    }
}