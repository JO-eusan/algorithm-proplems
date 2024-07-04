class Solution {
    public int solution(int n) {
        int answer = 0;
        
        /* 최대 공약수 구하기 */
        int max_factor = 1;
        for(int i=2; i<=6 && i<=n; i++){
            if(n%i == 0 && 6%i == 0)
                max_factor = i;
        }
        
        answer = max_factor * (n/max_factor) * (6/max_factor) / 6;
        
        return answer;
    }
}