class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // yellow -> 사각형 모양 맞추기
        for(int i=1; i<=Math.sqrt(yellow); i++) { // 세로
            int depth = i;
            int width = yellow / i;
            if(brown == ((depth + 2)*2 + width*2)) {
                answer[0] = width + 2;
                answer[1] = depth + 2;
            }
                
        }
        
        return answer;
    }
}