class Solution {
    /*
     * 붕대 감기
     * - t초 동안 감으면서 1초마다 x만큼 체력 회복 (+ t*x)
     * - t초 연속 붕대 감기 성공 -> + y만큼 추가 회복
     * - 최대 체력보다 커지는 것은 불가능
     * - 몬스터 공격 -> 연속 성공 시간 0초, -피해량
     * - 현재 체력 0 이하면 죽고 체력 회복 불가능
    */
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int nowHealth = health;
        int idx = 0;
        int dur = 0;
        
        for(int now=1; now<=attacks[attacks.length-1][0]; now++) {            
            if(now == attacks[idx][0]) {
                nowHealth -= attacks[idx][1];
                idx++;
                dur = 0;
                
                if(nowHealth <= 0) return -1;
                continue;
            }
            
            nowHealth += x;
            dur++;
            
            if(dur == t) {
                nowHealth += y;
                dur = 0;
            }
            nowHealth = Math.min(nowHealth, health);
            
            if(nowHealth <= 0) return -1;
        }
        
        return nowHealth;
    }
}