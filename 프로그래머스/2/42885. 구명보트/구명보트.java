import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        // min pointer & max pointer
        int min_pt = 0;
        int max_pt = people.length - 1;
        
        int n = 0; // 보낸 사람의 수
        while(n < people.length) {
            if(people[min_pt] + people[max_pt] <= limit) {
                n += 2;
                min_pt++;
                max_pt--;
            }
            else {
                n += 1;
                max_pt--;
            }
            answer++;
        }
        
        
        return answer;
    }
}