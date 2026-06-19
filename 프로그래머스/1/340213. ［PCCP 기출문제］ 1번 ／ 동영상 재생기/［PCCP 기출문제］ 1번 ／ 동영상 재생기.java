class Solution {
    /*
     * 동영상 재생기 3가지 기능
     * 1. 10초 전으로 이동: 'prev' 명령어 입력 -> Math.max(10초 전, 0분 0초)
     * 2. 10초 후로 이동: 'next' 명령어 입력 -> Math.min(10초 후, 동영상 길이)
     * 3. 오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간인 경우 자동으로 오프닝 끝나는 위치로 이동
     *
     * video_len = 동영상 길이
     * pos = 기능이 수행되기 직전의 재생 위치
     * op_start = 오프닝 시작 시각
     * op_end = 오프닝 끝나는 시각
    */
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] times = pos.split(":");
        int pos_mm = Integer.parseInt(times[0]); // 현재 분
        int pos_ss = Integer.parseInt(times[1]); // 현재 초
        
        String now = pos; // 현재 시각
        now = passOpening(now, op_start, op_end);
        System.out.println(now);
        
        for(String c : commands) {
            if(c.equals("prev")) {
                now = calculateTime(now, -10, video_len);
            } else if(c.equals("next")) {
                now = calculateTime(now, 10, video_len);
            }
            
            now = passOpening(now, op_start, op_end);
            System.out.println(now);
        }
        
        return now;
    }
    
    private String passOpening(String now, String op_start, String op_end) {
        String[] times = now.split(":");
        int n = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        
        String[] start = op_start.split(":");
        int start_time = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        
        String[] end = op_end.split(":");
        int end_time = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        
        if(start_time <= n && n <= end_time) {
            return op_end;
        }
        
        return now;
    }
    
    private String calculateTime(String now, int jump_ss, String video_len) {
        // now를 ss만큼 이동 (-10 or 10)
        // 1. 10초 전으로 이동: 'prev' 명령어 입력 -> Math.max(10초 전, 0분 0초)
        // 2. 10초 후로 이동: 'next' 명령어 입력 -> Math.min(10초 후, 동영상 길이)
        String[] times = now.split(":");
        int mm = Integer.parseInt(times[0]);
        int ss = Integer.parseInt(times[1]);
        
        String[] video = video_len.split(":");
        int video_mm = Integer.parseInt(video[0]);
        int video_ss = Integer.parseInt(video[1]);
        
        int result = Math.min(Math.max(mm * 60 + ss + jump_ss, 0), video_mm * 60 + video_ss);
        int result_mm = result / 60;
        int result_ss = result % 60;
        return String.format("%02d:%02d", result_mm, result_ss);
    }
}