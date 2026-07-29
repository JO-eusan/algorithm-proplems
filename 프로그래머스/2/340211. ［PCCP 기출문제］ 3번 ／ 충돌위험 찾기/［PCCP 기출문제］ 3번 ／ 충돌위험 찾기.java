import java.util.*;

class Solution {
    /*
     * 포인트 1~n : (r, c)로 표현
     * 로봇마다 운송 경로 존재 : m개의 포인트로 구성해 순서대로 방문
     * 사용 로봇은 x대이고 모든 로봇은 0초에 동시에 출발하고 1초마다 1칸씩 이동
     * 다음 포인트로 이동하는 경우 항상 최단 경로로 이동 (r좌표 이동 우선)
    */
    
    public int solution(int[][] points, int[][] routes) {
        int x = routes.length; 
        
        List<int[]>[] paths = new ArrayList[x];
        
        for(int i=0; i<x; i++) {
            paths[i] = new ArrayList<>();
        }
        
        for(int i=0; i<routes.length; i++) {
            int[] route = routes[i];
            int[] start = points[route[0] - 1];
            paths[i].add(new int[]{start[0], start[1]});
            
            for(int j=1; j<route.length; j++) {
                int[] prev = points[route[j-1] - 1];
                int[] now = points[route[j] - 1];
                
                if(prev[0] - now[0] > 0) {
                    for(int r=prev[0]-1; r>=now[0]; r--) {
                        paths[i].add(new int[] {r, prev[1]});
                    }
                } else if(prev[0] - now[0] < 0) {
                    for(int r=prev[0]+1; r<=now[0]; r++) {
                        paths[i].add(new int[] {r, prev[1]});
                    }
                }
                
                if(prev[1] - now[1] > 0) {
                    for(int c=prev[1]-1; c>=now[1]; c--) {
                        paths[i].add(new int[] {now[0], c});
                    }
                } else if(prev[1] - now[1] < 0) {
                    for(int c=prev[1]+1; c<=now[1]; c++) {
                        paths[i].add(new int[] {now[0], c});
                    }
                }
            }
        }
        
        int time = paths[0].size();
        for(int i=1; i<x; i++) {
            time = Math.max(paths[i].size(), time);
        }
        
        int answer = 0;
        
        for(int t=0; t<time; t++) {
            List<int[]> pairs = new ArrayList<>();
            
            for(int i=0; i<x; i++) {
                List<int[]> path = paths[i];
                if(path.size() > t) {
                    pairs.add(path.get(t));
                }
            }
            
            int[][] visited = new int[101][101];
            for(int[] p : pairs) {
                if(visited[p[0]][p[1]] == 1) {
                    answer++;
                    visited[p[0]][p[1]]++;
                }
                visited[p[0]][p[1]]++;
            }
        }
        
        return answer;
    }
}