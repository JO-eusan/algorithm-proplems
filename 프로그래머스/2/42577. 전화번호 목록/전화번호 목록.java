import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. 조회에 시간 복잡도가 O(1)를 가지기 위해 중복되지 않은 전화번호를 Set에 저장한다.
        Set<String> phoneNumbers = new HashSet<>();
        for (String p : phone_book) {
            phoneNumbers.add(p);
        }
        
        // 2. 하나씩 순회하면서 부분 문자열에 해당하는 전화번호가 있는지 확인한다.
        for (String p : phoneNumbers) {
            for (int i = 0; i < p.length(); i++) {
                if (phoneNumbers.contains(p.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}