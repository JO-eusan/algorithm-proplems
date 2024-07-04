import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        /* 곱의 최대값은 큰 수 두개를 곱하면 된다. */
        
        Arrays.sort(numbers);
        int answer = numbers[numbers.length-1] * numbers[numbers.length-2];
        return answer;
    }
}