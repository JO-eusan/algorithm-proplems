class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;
        int next_a = a;
        int next_b = b;

        while(next_a != next_b) {
            round++;
            
            next_a = (next_a + 1) / 2;
            next_b = (next_b + 1) / 2;
        }
        
        return round;
    }
}