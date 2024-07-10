import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer_tmp = new ArrayList<>();
        
        /* 장르 별 총 재생 수 */
        HashMap<String, Integer> counts = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            if(!counts.containsKey(genres[i]))
                counts.put(genres[i], plays[i]);
            else
                counts.put(genres[i], counts.get(genres[i])+plays[i]);
        }
        
        /* 총 재생 수 기준으로 정렬 -> list 활용 */
        List<String> keySet = new ArrayList<>(counts.keySet());
        keySet.sort((o1, o2) -> counts.get(o2).compareTo(counts.get(o1)));
        
        /* 장르 마다 기준에 적합한 앨범 넣기 */
        for(int i=0; i<keySet.size(); i++) {
            for(int n=0; n<2; n++) { // 최대 2개의 앨범 선택
                String max_idx = null;
                for(int j=0; j<plays.length; j++) {
                    if(max_idx == null && genres[j].equals(keySet.get(i)) 
                                                    && !answer_tmp.contains(j))
                        max_idx = String.valueOf(j);
                    else if(genres[j].equals(keySet.get(i)) && !answer_tmp.contains(j)
                            && plays[j] > plays[Integer.parseInt(max_idx)])
                        max_idx = String.valueOf(j);
                }
                if(max_idx != null) answer_tmp.add(Integer.parseInt(max_idx));
            }
        }
        
        /* tmp -> answer 배열로 교체 */
        int[] answer = new int[answer_tmp.size()];
        
        for(int i=0; i<answer_tmp.size(); i++)
            answer[i] = answer_tmp.get(i);
        return answer;
    }
}