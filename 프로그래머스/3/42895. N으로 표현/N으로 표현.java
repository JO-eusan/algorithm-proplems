import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        //통 만들기
        List<HashSet<Integer>> list = new ArrayList<>();
        
        //8개의 통 만들기
        for(int i=0; i<=8; i++) {
            list.add(new HashSet<Integer>());
        }
        
        //i=1인 경우부터 시작
        list.get(1).add(N);
        if(number == N) return 1;
        
        //i=2 ~
        for(int i=2; i<=8; i++) {
            HashSet<Integer> tmp = list.get(i);
            
            //이전 i값에서 현재 i값 만들기
            for(int j=1; j<i; j++) {
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i-j);
                
                for(int x : a) {
                    for(int y : b) {
                        tmp.add(x + y); // 더하기
                        tmp.add(x - y); // 빼기
                        tmp.add(x * y); // 곱하기
                        if(x != 0 && y != 0) tmp.add(x / y); // 나누기
                    }
                }
                tmp.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            
            // i개의 N으로 number를 만들 수 있다면 끝
            if(tmp.contains(number)) return i;
        }
        
        // 8개보다 더 많은 숫자가 필요하므로 -1
        return -1; 
    }
}