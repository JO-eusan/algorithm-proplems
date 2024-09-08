import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); //단어의 개수
        int M = Integer.parseInt(firstLine[1]); //외울 수 있는 단어 길이

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            String tmp = br.readLine();

            if(tmp.length() < M) continue;

            if(!map.containsKey(tmp))
                map.put(tmp, 1);
            else
                map.put(tmp, map.get(tmp) + 1);
        }
        

        List<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)) {
                    if(o1.length() == o2.length())
                        return o1.compareTo(o2);
                    return o2.length() - o1.length();
                }
                return map.get(o2) - map.get(o1);
            }
        });

        for(int i=0; i<words.size(); i++) {
            bw.write(words.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}