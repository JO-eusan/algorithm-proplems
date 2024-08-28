import java.util.*;

class Solution {
    
    boolean[] visited;
    ArrayList<String> list = new ArrayList<>(); //경로를 저장할 리스트
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        visited = new boolean[tickets.length]; //티켓 사용 여부
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list); //가능한 경로가 여러개 존재하면 알파벳 순서
        answer = list.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(int cnt, String now, String path, String[][] tickets) {
        if(cnt == tickets.length) {
            list.add(path);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && now.equals(tickets[i][0])) { //출발지 동일 티켓
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}