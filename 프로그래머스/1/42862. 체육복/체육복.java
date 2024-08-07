import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        
        /* 현재 사용 가능한 여분 체육복 번호를 list에 넣기 */
        List<Integer> lost_list = new ArrayList<>();
        for(int i=0; i<lost.length; i++) {
            lost_list.add(lost[i]);
        }
        List<Integer> reserve_list = new ArrayList<>();
        for(int i=0; i<reserve.length; i++) {
            reserve_list.add(reserve[i]);
        }
        
        // 자기 자신은 제외
        for(int i=0; i<lost.length; i++) {
            if(reserve_list.contains(lost[i])) {
                answer++;
                reserve_list.remove(Integer.valueOf(lost[i]));
                lost_list.remove(Integer.valueOf(lost[i]));
            }
        }
        
        // 수업 들을 수 있는 학생 count 시작
        for(int i=0; i<lost_list.size(); i++) {
            if(reserve_list.contains(lost_list.get(i)-1)) {
                answer++;
                reserve_list.remove(Integer.valueOf(lost_list.get(i)-1));
                continue;
            }
            else if(reserve_list.contains(lost_list.get(i)+1)) {
                answer++;
                reserve_list.remove(Integer.valueOf(lost_list.get(i)+1));
                continue;
            }
        }
        
        return answer;
    }
}