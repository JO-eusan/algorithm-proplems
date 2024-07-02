class Solution {
    public int[] solution(int n) {
        /* n까지의 수 중에서 홀수의 개수만큼 크기를 갖는 배열 생성 */
        int[] answer = new int[(n+1)/2];
        
        int idx = 0;
        for(int i=1; i<=n; i++) {
            if(i%2 == 1)
                answer[idx++] = i;
        }
        
        return answer;
    }
}