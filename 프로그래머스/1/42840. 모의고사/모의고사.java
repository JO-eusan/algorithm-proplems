import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        /* 수포자 1 답안지 */
        int[] answer_1 = new int[answers.length];
        int cnt = 0;
        for(int i=0; i<answers.length; i++) {
            answer_1[i] = (cnt%5) + 1;
            cnt++;
        }
        
        /* 수포자 2 답안지 */
        int[] answer_2 = new int[answers.length] ;
        cnt = 0;
        for(int i=0; i<answers.length; i++) {
            if(i%2 == 0)
                answer_2[i] = 2;
            else {
                int tmp = (cnt%5) + 1;
                if(tmp == 2) {
                    cnt++;
                    answer_2[i] = (cnt%5) + 1;
                }
                else {
                    answer_2[i] = tmp;
                }
                cnt++;
            }
        }
        
        /* 수포자 3 답안지 */
        int[] answer_3 = new int[answers.length] ;
        cnt = 0;
        int[] sequence = {3, 1, 2, 4, 5}; 
        for(int i=0; i<answers.length; i++) {
            answer_3[i] = sequence[cnt%5];
            
            if(i%2 == 1) cnt++;
        } 
        
        for(int i=0; i<answers.length; i++) {
            System.out.print(answer_3[i] + " ");
        }
        
        /* 정답 개수 세기 */
        int cnt_1 = 0, cnt_2 = 0, cnt_3 = 0;
        for(int i=0; i<answers.length; i++) {
            if(answer_1[i] == answers[i])
                cnt_1++;
            if(answer_2[i] == answers[i])
                cnt_2++;
            if(answer_3[i] == answers[i])
                cnt_3++;
        }
        
        /* 최대값 찾기 */
        int max = cnt_1;
        if(cnt_2 > max) max = cnt_2;
        if(cnt_3 > max) max = cnt_3;
        
        List<Integer> list = new ArrayList<>();
        if(max == cnt_1) list.add(1);
        if(max == cnt_2) list.add(2);
        if(max == cnt_3) list.add(3);
        
        Collections.sort(list);
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}