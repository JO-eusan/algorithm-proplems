import java.util.*;

class Solution {
    
    int maxValue;
    
    public void recursive(int k, int[][] dungeons, List<Integer> picked) {
        if(picked.size() > maxValue) {
            maxValue = picked.size();
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(!picked.contains(i) && k >= dungeons[i][0]) {
                List<Integer> newPicked = new ArrayList<>(picked);
                newPicked.add(i);
                recursive(k - dungeons[i][1], dungeons, newPicked);
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        recursive(k, dungeons, new ArrayList<>());
        return maxValue;
    }
}