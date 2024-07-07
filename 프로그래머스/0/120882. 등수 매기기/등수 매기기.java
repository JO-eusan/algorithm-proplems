import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        double[] mean_scores = new double[score.length];
        for(int i=0; i<score.length; i++) 
            mean_scores[i] = (score[i][0] + score[i][1]) / (double)2;
        
        HashMap<Double, Integer> table = new HashMap<>();
        
        Double[] sorted_mean_scores = new Double[score.length];
        for(int i=0; i<score.length; i++)
            sorted_mean_scores[i] = mean_scores[i];
        Arrays.sort(sorted_mean_scores, Collections.reverseOrder());
        
        int rank = 1;
        for(int i=0; i<score.length; i++) {
            if(!table.containsKey(sorted_mean_scores[i]))
                table.put(sorted_mean_scores[i], rank);
            rank++;
        }
        
        for(int i=0; i<answer.length; i++) 
            answer[i] = table.get(mean_scores[i]);
        
        
        return answer;
    }
}