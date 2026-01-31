import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르 별 총 재생 수에 대해 내림차순으로 정렬합니다.
        int musicNumber = genres.length;
        Map<String, Integer> counter = new HashMap<>();
        
        for(int i = 0; i < musicNumber; i++) {
            String genre = genres[i];
            int play = plays[i];
            counter.put(genre, counter.getOrDefault(genre, 0) + play);
        }
        
        List<String> sortedGenres = new ArrayList<>(counter.keySet());
        sortedGenres.sort((o1, o2) -> counter.get(o2).compareTo(counter.get(o1)));

        
        // 2. 장르 별 노래를 저장합니다.
        Map<String, List<Music>> musics = new HashMap<>();
        
        for(int i = 0; i < musicNumber; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!musics.keySet().contains(genre)) {
                musics.put(genre, new ArrayList<>());
            }
            
            List<Music> newMusics = musics.get(genre);
            newMusics.add(new Music(i, play));
            musics.put(genre, newMusics);
        }
        
        // 3. 총 재생 수가 많은 장르부터 노래를 정렬하고 앨범에 최대 2개 노래를 저장합니다.
        List<Integer> album = new ArrayList<>();
        for(String genre : sortedGenres) {
            List<Music> sortedMusic = musics.get(genre);
            Collections.sort(sortedMusic);
            
            for (int i = 0; i < Math.min(2, sortedMusic.size()); i++) {
    album.add(sortedMusic.get(i).id);
}
        }
        
        // 4. List를 Array로 변환
        int[] answer = new int[album.size()];
        for(int i = 0; i < album.size(); i++) {
            answer[i] = album.get(i);
        }
        return answer;
    }
}

class Music implements Comparable<Music> {
    int id;
    int plays;
    
    public Music(int id, int plays) {
        this.id = id;
        this.plays = plays;
    }
    
    @Override
    public int compareTo(Music o) {
        if (this.plays != o.plays) {
            return o.plays - this.plays; // 내림차순
        }
        return this.id - o.id;
    }
}