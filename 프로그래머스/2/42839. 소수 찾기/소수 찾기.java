import java.util.*;

class Solution {
    
    private static HashSet<Integer> numberSet = new HashSet<>();
    private static char[] arr; // 종이 조각
    private static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        
        // 모든 조합의 숫자 만들기
        permutation("", 0);   
        
        answer = numberSet.size();
        
        return answer;
    }
           
    /* 소수 판별 */
    public boolean isFactor(int a) {
        if(a == 0 || a == 1) return false;
        
        for(int i=2; i<=Math.sqrt(a); i++) {
            if(a % i == 0) {
                return false;
            }
        }
        return true;
    } 
    
    /* 가능한 숫자 조합 찾고 소수면 add */
    public void permutation(String str, int cnt) {
        
        if(str != "") {
            if(isFactor(Integer.parseInt(str)))
                numberSet.add(Integer.parseInt(str));
        }
        
        if(cnt == arr.length) return; // 종이 개수만큼 다하면 return
        
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(str+arr[i], cnt+1);
                visited[i] = false;
            }
        }
    }
}