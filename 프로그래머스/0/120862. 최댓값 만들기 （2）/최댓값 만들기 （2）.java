import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        /* 음수끼리 곱한 최대값이거나 양수끼리 곱한 최대값일 것 */
        
        Arrays.sort(numbers);
        int max = numbers[numbers.length-1] * numbers[numbers.length-2];
        
        if(numbers[0] * numbers[1] > max)
            max = numbers[0] * numbers[1];
        
        int answer = max;
        return answer;
    }
}