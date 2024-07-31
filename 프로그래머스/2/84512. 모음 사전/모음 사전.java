import java.util.*;

class Solution {
    
    private static List<String> dict = new ArrayList<>();
    private static char[] arr;
    private static boolean[] visited; 
    
    public int solution(String word) {
        int answer = 0;
        
        arr = new char[] {'A', 'E', 'I', 'O', 'U'};
        visited = new boolean[5];
        
        permutation("", 0);
        
        Collections.sort(dict);
        for(int i=0; i<10; i++) {
            System.out.println(dict.get(i));
        }
        for(int i=0; i<dict.size(); i++) {
            if(dict.get(i).equals(word))
                answer = i + 1;
        }
        
        return answer;
    }
    
    public void permutation(String str, int cnt) {
        if(str != "") {
            dict.add(str);
        }
        
        if(cnt == 5) return;
        
        for(int i=0; i<5; i++) {
            permutation(str + arr[i], cnt + 1);
        }
    }
}