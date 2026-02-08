import java.util.*;

class Solution {
    
    List<String> dict = new ArrayList<>();
    String[] alphabets = {"A", "E", "I", "O", "U"};
    
    public void dfs(String str, int cnt) {
        if(!str.equals("")) dict.add(str);
        if(cnt == 5) return;
        
        for(int i=0; i<5; i++) {
            dfs(str + alphabets[i], cnt + 1);
        }
    }
    
    public int solution(String word) {
        dfs("", 0);
        Collections.sort(dict);
        
        int answer = 0;
        for(int i=0; i<dict.size(); i++) {
            if(dict.get(i).equals(word)) {
                answer = i + 1;
            }
        }
        return answer;
    }
}