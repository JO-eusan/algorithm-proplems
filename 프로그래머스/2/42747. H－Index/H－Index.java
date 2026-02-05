import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 1. 내림차순 정렬을 위해 Collections을 사용한다.
        List<Integer> numbers = new ArrayList<>();
        for(int c : citations) {
            numbers.add(c);
        }
        
        // 2. 가장 큰 인용 수 부터 h 조건에 대한 탐색을 수행한다.
        Collections.sort(numbers, Collections.reverseOrder());
        int h = numbers.get(0);
        
        while (true) {
            int count = 0;
            
            for(int n : numbers) {
                if(n < h) {
                    break;
                }     
                count++;
            }
            
            if (count >= h) {
                break;
            }
            h--;
        }
        
        return h;
    }
}