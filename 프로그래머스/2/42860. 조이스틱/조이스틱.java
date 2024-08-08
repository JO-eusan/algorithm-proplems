class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로만 쭉 이동하는 횟수
        
        // 위아래 조작 횟수 계산
        int[] control = new int[name.length()];
        for(int i=0; i<name.length(); i++) {
            control[i] = Math.min((name.charAt(i) - 'A'), ('Z' - name.charAt(i) + 1));
        }
        
        // 좌우 조작
        for(int i=0; i<name.length(); i++) {
            
            answer += control[i];
            
            if(i < name.length() - 1 && control[i+1] == 0) {
                int endA = i + 1;
                while(endA < name.length() && control[endA] == 0)
                    endA++;
                move = Math.min(move, i*2 + (name.length() - endA)); // 오른쪽 -> 왼쪽
                move = Math.min(move, i + (name.length() - endA) * 2); // 왼쪽 -> 오른쪽
            }
        }
        
        return answer + move;
    }
}