import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. numbers의 숫자를 String으로 모은다.
        List<String> singleNumbers = new ArrayList<>();
        for(int n : numbers) {
            singleNumbers.add(String.valueOf(n));
        }
        
        // 2. 모은 String을 내림차순으로 정렬하면 큰 수가 앞에 오면서 큰 수가 된다.
        Collections.sort(singleNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (singleNumbers.get(0).equals("0")) {
            return "0";
        }
        return String.join("", singleNumbers);
    }
}