import java.util.*;

class Solution {
    /*
     * A가 n/2 주사위, B가 n/2 주사위를 모두 굴린 뒤 나온 수들을 모두 합해 점수 계산
     * A는 자신이 승리할 확률이 가장 높아지도록 가져감
    */
    private long maxWin = -1;
    private int[] answer;
    
    public int[] solution(int[][] dice) {
        answer = new int[dice.length / 2];
        dfs(0, 0, 0, dice);
        return answer;
    }
    
    private void dfs(int start, int cnt, int mask, int[][] dice) {
        if(cnt == dice.length / 2) {
            // a와 b가 나올 수 있는 주사위
            List<Integer> aDice = new ArrayList<>();
            List<Integer> bDice = new ArrayList<>();
            
            for(int i=0; i<dice.length; i++) {
                if((mask & (1<<i)) != 0) {
                    aDice.add(i);
                } else {
                    bDice.add(i);
                }
            }
            
            // 각 주사위별 가능 점수들
            List<Integer> aScore = new ArrayList<>();
            List<Integer> bScore = new ArrayList<>();
            
            makeScore(0, 0, aDice, dice, aScore);
            makeScore(0, 0, bDice, dice, bScore);
            
            Collections.sort(bScore);
            
            long win = 0;
            for(int score : aScore) {
                win += lowerBound(bScore, score);
            }
            if(win > maxWin) {
                maxWin = win;
                
                int idx = 0;
                for(int i=0; i<dice.length; i++) {
                    if((mask & (1<<i)) != 0) {
                        answer[idx++] = i + 1;
                    }
                }
            }

            return;
        }
        
        for(int i=start; i<dice.length; i++) {
            dfs(i+1, cnt+1, mask | (1<<i), dice);
        }
    }
    
    private void makeScore(int idx, int sum, List<Integer> selected, int[][] dice, List<Integer> score) {
        if(idx == selected.size()) {
            score.add(sum);
            return;
        }
        
        int diceIdx = selected.get(idx);
        for(int i=0; i<6; i++) {
            makeScore(idx+1, sum + dice[diceIdx][i], selected, dice, score);
        }
    }
    
    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while(left < right) {
            int mid = (left + right) / 2;
            
            if(target > list.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}