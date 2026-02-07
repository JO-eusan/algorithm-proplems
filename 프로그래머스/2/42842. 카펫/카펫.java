import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        // 1. yellow 개수로 만들 수 있는 경우의 수를 구한다.
        Set<Integer> firstPair = new HashSet<>();
        
        for(int i=1; i<=yellow; i++) {
            if(yellow % i == 0 && !firstPair.contains(yellow / i)) {
                firstPair.add(i);
            }
        }
        
        // 2. 해당 원소의 값으로 brown의 개수를 일치하는 값을 찾는다.
        int[] answer = new int[2];
        
        for(int pair : firstPair) {
            int maxLength = Math.max(pair, yellow / pair);
            int minLength = Math.min(pair, yellow / pair);
            
            if((2 * (maxLength + minLength) + 4) == brown) {
                answer[0] = maxLength + 2;
                answer[1] = minLength + 2;
                break;
            }
        }
        return answer;
    }
}