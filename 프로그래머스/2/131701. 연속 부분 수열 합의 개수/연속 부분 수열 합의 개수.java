import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        int n = elements.length;
        
        for(int i=1; i<=n; i++) {
            // 초기값 넣기
            int sum = 0;
            for(int j=0; j<i; j++) {
                sum += elements[j];
            }
            sums.add(sum);
            
            // 다음 부분합 구하기
            for(int j=1; j<n; j++) {
                sum -= elements[j-1];
                sum += elements[(j+i-1) % n];
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}