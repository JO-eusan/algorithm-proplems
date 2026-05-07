import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        if(isLongerThanOne(words[0])) {
            set.add(words[0]);
        }
        
        for(int i=1; i<words.length; i++) {
            String prev = words[i-1];
            
            if(isLastWordStart(prev.charAt(prev.length()-1), words[i])
              && !isDuplicate(set, words[i])
              && isLongerThanOne(words[i])) {
                set.add(words[i]);
                continue;
            }
            return new int[] {i%n + 1, i/n + 1};
        }

        return new int[] {0, 0};
    }
    
    private boolean isLastWordStart(char start, String word) {
        return start == word.charAt(0);
    }
    
    private boolean isDuplicate(Set<String> words, String word) {
        return words.contains(word);
    }
    
    private boolean isLongerThanOne(String word) {
        return word.length() > 1;
    }
}