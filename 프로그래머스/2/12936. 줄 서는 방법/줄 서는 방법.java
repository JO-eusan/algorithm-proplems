import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> nums = new ArrayList<>();
        
        // factorial 저장 ex. fact[i] = i!
        long[] fact = new long[n+1];
        fact[0] = 1;
        for(int i=1; i<=n; i++) {
            fact[i] = fact[i-1] * i;
            nums.add(i);
        }
        
        int[] answer = new int[n];
        long idx = k - 1;
        
        // 앞자리부터 하나씩 결정
        for(int i=0; i<n; i++) {
            // 현재 숫자를 하나 고르면 뒤에는 (남은 개수)! 만큼 경우의 수 존재
            long block = fact[n - i - 1];
            
            int group = (int)(idx / block);
            answer[i] = nums.get(group);
            
            // 선택한 숫자는 다시 사용 X
            nums.remove(group);
            idx %= block;
        }
        
        return answer;
    }
}