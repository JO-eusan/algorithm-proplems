import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    
    public int solution(String begin, String target, String[] words) {
        // begin + words 단어들 관계를 그래프로 표현
        String[] w = new String[words.length + 1];
        
        w[0] = begin;
        for(int i=1; i<=words.length; i++) {
            w[i] = words[i-1];
        }
        
        graph = new ArrayList[w.length];
        
        for(int i=0; i<w.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int wordLength = begin.length();
        
        for(int i=0; i<w.length; i++) {
            for(int j=i+1; j<w.length; j++) {
                if(calculateSameCharacter(w[i], w[j]) == wordLength - 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        return bfs(target, w);
    }
    
    private int bfs(String target, String[] w) {
        int wordLength = target.length();
        boolean[] visited = new boolean[graph.length];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0}); // {node, 변환 횟수}
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int node = now[0];
            int count = now[1];
            
            if(calculateSameCharacter(w[node], target) == wordLength) {
                return count;
            }
            
            for(int next : graph[node]) {
                if(visited[next]) continue;
                
                q.offer(new int[] {next, count+1});
                visited[next] = true;
            }
        }
        
        return 0;
    }
    
    private int calculateSameCharacter(String w1, String w2) {
        int count = 0;
        
        for(int i=0; i<w1.length(); i++) {
            if(w1.charAt(i) == w2.charAt(i)) {
                count++;
            }
        }
        
        return count;
    }
}