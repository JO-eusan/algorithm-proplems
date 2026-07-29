import java.util.*;

class Solution {
    
    /*
     * 동영상 재생기 기능 3가지
     * 1. 10초 전 이동('prev') : pos = Math.max(0, now-10s)
     * 2. 10초 후 이동('next') : pos = Math.min(동영상 길이, now+10s)
     * 3. 오프닝 건너뛰기 : op_start <= 현재 재생 위치 <= op_end이면 자동으로 오프닝 끝나는 위치로 이동
    */
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_sec = parseSeconds(video_len);
        int op_start_sec = parseSeconds(op_start);
        int op_end_sec = parseSeconds(op_end);
        int now_sec = parseSeconds(pos);
        
        if(op_start_sec <= now_sec && now_sec <= op_end_sec) {
            now_sec = op_end_sec;
        }
        
        for(String com : commands) {
            if(com.equals("prev")) { // -10
                now_sec = Math.max(0, now_sec-10);
            } else { // +10
                now_sec = Math.min(video_sec, now_sec+10);
            }
            
            if(op_start_sec <= now_sec && now_sec <= op_end_sec) {
                now_sec = op_end_sec;
            }
        }
        
        return parseString(now_sec);
    }
    
    private int parseSeconds(String time) {        
        String[] token = time.split(":");
        return Integer.parseInt(token[0]) * 60 + Integer.parseInt(token[1]);
    }
    
    private String parseString(int seconds) {
        int mm = seconds / 60;
        int ss = seconds % 60;
        
        return String.format("%02d:%02d", mm, ss);
    }
}