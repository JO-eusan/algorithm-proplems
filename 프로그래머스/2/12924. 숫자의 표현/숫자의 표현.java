import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int n) {
        int answer = 0;

        // start: 시작 자연수
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            for (int end = start; end <= n; end++) {
                sum += end;
                if (sum == n) {
                    answer++;
                    break; 
                }
                if (sum > n) break;
            }
        }
        return answer;
    }
}