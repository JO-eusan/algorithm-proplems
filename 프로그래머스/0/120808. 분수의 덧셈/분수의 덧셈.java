class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int numer = numer1*denom2 + numer2*denom1;
        int denom = denom1*denom2;
        
        /* 최대 공약수 찾기 */
        int max_factor = 1;
        for(int i=2; i<=numer && i<=denom; i++) {
            if(numer%i == 0 && denom%i == 0)
                max_factor = i;
        }
        
        answer[0] = numer / max_factor;
        answer[1] = denom / max_factor;
        
        return answer;
    }
}