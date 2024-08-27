import java.util.*;

class Solution {
    
    int[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new int[words.length];
        
        bfs(begin, target, words);
        
        //target 최단 경로 찾기
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(target)) {
                if(visited[i] != 0)
                    answer = visited[i];
            }
        }
        
        return answer;
    }
    
    public void bfs(String begin, String target, String[] words) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(-1); //begin index = -1
        
        while(!queue.isEmpty()) {
            int current_idx = queue.poll();
            String current = "";
            
            if(current_idx == -1) current = begin;
            else current = words[current_idx];
            
            for(int i=0; i<words.length; i++) {
                if(visited[i] == 0 && isChange(current, words[i])) {
                    queue.add(i);
                    
                    if(current_idx == -1) visited[i] = 1;
                    else visited[i] = visited[current_idx] + 1;
                }
            }
        }
    }
    
    public boolean isChange(String current, String word) {
        int cnt = 0; //다른 알파벳 횟수
        
        for(int i=0; i<word.length(); i++) {
            if(current.charAt(i) != word.charAt(i))
                cnt++;
        }
        
        if(cnt == 1) return true;
        else return false;
    }
}