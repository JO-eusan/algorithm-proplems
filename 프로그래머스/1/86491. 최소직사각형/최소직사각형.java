class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        /* 긴 길이의 변을 가로 길이 index = 0에 저장 */
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) { // swap
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        /* 가로 최대값 x 세로 최대값 */
        int max_1 = sizes[0][0];
        for(int i=1; i<sizes.length; i++) {
            if(sizes[i][0] > max_1)
                max_1 = sizes[i][0];
        }
        
        int max_2 = sizes[0][1];
        for(int i=1; i<sizes.length; i++) {
            if(sizes[i][1] > max_2)
                max_2 = sizes[i][1];
        }
        
        answer = max_1 * max_2;
        
        return answer;
    }
}