import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        
        /* 종류 count */
        for(int i=0; i<nums.length; i++) {
            if(!count.containsKey(nums[i]))
                count.put(nums[i], 1);
            else
                count.put(nums[i], count.get(nums[i])+1);
        }
        
        /* N/2마리 선택 */
        if(nums.length/2 >= count.size()) 
            answer = count.size();
        else
            answer = nums.length/2;
        
        return answer;
    }
}