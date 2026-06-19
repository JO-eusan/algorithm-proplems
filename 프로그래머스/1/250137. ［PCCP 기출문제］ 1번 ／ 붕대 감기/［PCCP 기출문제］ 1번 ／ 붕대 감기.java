class Solution {
    /*
     * 붕대 감기 = t초 동안 붕대를 감으면 1초마다 x만큼 체력 회복
     * t초 연속으로 붕대 감는거 성공하면 +y 만큼 추가 체력 회복
     * 현재 체력이 최대 체력보다 커질 수는 없음
     * 몬스터 공격 당하면 체력 회복 X -> 연속 성공 시간 0
     * 몬스터 공격 당하면 정해진 피해량만큰 현재 체력 감소
     * 현재 체력이 0이하가 되면 캐릭터는 죽어서 체력 회복 중단 후 -1 return
     *
     * bandage[0] = 붕대감기 기술의 시전시간
     * bandage[1] = 초당 회복량
     * bandage[2] = 추가 회복량
     * health = 최대 체력
    */
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int cur_health = health;
        int sequence = 0;
        
        int attack_idx = 0;
        
        for(int time=1; time<=attacks[attacks.length-1][0]; time++) {
            if(attack_idx < attacks.length && time == attacks[attack_idx][0]) {
                cur_health -= attacks[attack_idx][1]; // 공격
                attack_idx++;
                sequence = 0;
                
                if(cur_health <= 0) {
                    return -1;
                }
            } else {
                cur_health = Math.min(cur_health + bandage[1], health); // 회복
                sequence++;
                
                if(sequence == bandage[0]) {
                    cur_health = Math.min(cur_health + bandage[2], health); // 추가 회복
                    sequence = 0;
                }
            }
        }
        
        return cur_health <= 0 ? -1 : cur_health;
    }
}