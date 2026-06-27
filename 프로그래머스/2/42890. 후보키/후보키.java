import java.util.*;

class Solution {
    /*
     * 후보키 속성
     * 1. 모든 튜플에 대해 유일하게 식별 -> 중복되는 값이 없어야 한다.
     * 2. 1번을 만족하는 키를 구성하는 속성 중 하나라도 제외하는 경우 유일성이 깨짐
    */
    
    private Set<Integer> count = new HashSet<>();
    
    public int solution(String[][] relation) {
        // 각 컬럼을 선택하는 경우/선택하지 않는 경우로 모든 경우 살펴보기
        // 시간 복잡도 O(2^8)
        dfs(0, relation, 0);
        return count.size();
    }
    
    private void dfs(int idx, String[][] relation, int mask) {
        if(idx == relation[0].length) {
            if(mask == 0) return;
            
            if(isMinimal(mask) && isUnique(relation, mask)) {
                count.add(mask);
            }
            return;
        }
        
        dfs(idx+1, relation, mask); // 방문 X
        dfs(idx+1, relation, mask | (1<<idx)); // 방문 O
    }
    
    private boolean isMinimal(int mask) {
        for(int key : count) {
            if((mask & key) == key) { // 기존 후보키에 포함되면 최소성 깨짐
                return false;
            }
        }
        return true;
    }
    
    private boolean isUnique(String[][] relation, int mask) {
        Set<String> tuples = new HashSet<>();
        
        for(int i=0; i<relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<relation[0].length; j++) {
                if((mask & (1<<j)) != 0) {
                    sb.append("," + relation[i][j]);
                }
            }
            tuples.add(sb.toString());
        }
        
        return relation.length == tuples.size();
    }
}