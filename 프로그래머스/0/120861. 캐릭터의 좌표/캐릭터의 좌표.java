class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        for(int i=0; i<keyinput.length; i++) {
            String tmp = keyinput[i];
            
            if(tmp.equals("up") && (answer[1] < board[1]/2))
                answer[1]++;
            else if(tmp.equals("down") && (answer[1] > board[1]/2*(-1)))
                answer[1]--;
            else if(tmp.equals("left") && (answer[0] > board[0]/2*(-1)))
                answer[0]--;
            else if(tmp.equals("right") && (answer[0] < board[0]/2))
                answer[0]++;
        }
        
        return answer;
    }
}