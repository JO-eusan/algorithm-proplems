import java.util.*;

class Solution {
    
    private static int n;
    private static int[] arr; // 선택 원소
    private static boolean[] visited; // 방문 처리
    private static List<Integer> list = new ArrayList<>();
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        
        n = dungeons.length;
        arr = new int[n];
        visited = new boolean[n];
        
        permutation(0, k, dungeons);
        
        for(int i=0; i<list.size(); i++) {
            if(answer < list.get(i))
                answer = list.get(i);
        }
        
        return answer;
    }
    
    private static void permutation(int cnt, int k, int[][] dungeons) {
        if(cnt == n) {
            int count = 0;
            int k_tmp = k;
            for(int i=0; i<arr.length; i++) {
                
                if(k_tmp >= dungeons[arr[i]][0]) {
                    k_tmp -= dungeons[arr[i]][1];
                    count++;
                }
                else break;
            }
            
            list.add(count);
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt + 1, k, dungeons);
                visited[i] = false;
            }
        }
    }
}