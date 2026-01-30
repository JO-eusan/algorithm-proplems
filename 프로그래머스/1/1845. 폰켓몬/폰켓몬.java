import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int ponketmonSize = nums.length;
        int pickedSize = ponketmonSize / 2;
        
        // 1. 폰켓몬의 종류를 계산한다.
        Set<Integer> category = new HashSet<>();
        for(int n : nums) {
            category.add(n);
        }
        
        // 2. 만약 선택할 개수보다 종류의 개수가 많다면 선택할 개수가 답이고
        // 3. 만약 선택할 개수가 종류의 개수보다 적다면 종류의 개수가 답이다.
        if (pickedSize <= category.size()) {
            return pickedSize;
        } else {
            return category.size();
        }
    }
}