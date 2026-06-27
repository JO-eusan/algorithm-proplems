import java.util.*;

class Solution {
    
    private Set<Integer> count = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, user_id, banned_id, 0); // user_id가 선택되는지 안되는지 방문
        return count.size();
    }
    
    private void dfs(int cnt, String[] user_id, String[] banned_id, int user_mask) {
        if(cnt == banned_id.length) {
            count.add(user_mask);
            return;
        }
        
        for(int i=0; i<user_id.length; i++) {
            if((user_mask & (1<<i)) == 0 && isMatch(banned_id[cnt], user_id[i])) {
                dfs(cnt+1, user_id, banned_id, user_mask | (1<<i));
            }
        }
    }
    
    private boolean isMatch(String id, String user) {
        if(id.length() != user.length()) {
            return false;
        }
        
        for(int i=0; i<id.length(); i++) {
            char ch = id.charAt(i);
            
            if(ch == '*') {
                continue;
            } else if(ch != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}