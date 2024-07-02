class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        
        int max_idx = 0;
        for(int i=1; i<array.length; i++){
            if(array[max_idx] < array[i])
                max_idx = i;
        }
        
        answer[0] = array[max_idx];
        answer[1] = max_idx;
        
        return answer;
    }
}