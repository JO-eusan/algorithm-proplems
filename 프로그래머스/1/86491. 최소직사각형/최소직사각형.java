import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxWidth = Integer.MIN_VALUE;
        int maxHight = Integer.MIN_VALUE;
        
        for(int[] size : sizes) {
            int big = Math.max(size[0], size[1]);
            int small = Math.min(size[0], size[1]);
            
            maxWidth = Math.max(maxWidth, big);
            maxHight = Math.max(maxHight, small);
        }
        
        return maxWidth * maxHight;
    }
}