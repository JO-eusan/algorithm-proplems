import java.io.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        visited = new boolean[N]; // 0 ~ N-1 index -> 출력할 때는 + 1
        traversal(M, 0, "");
    }

    public static void traversal(int M, int prev, String num) {

        if(M == 0) {
            System.out.println(num);
            return;
        }

        for(int i=prev; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;

                if(num.equals("")) traversal(M-1, i+1,  String.valueOf(i+1));
                else traversal(M-1, i+1, num + " " + (i+1));
                
                visited[i] = false;
            }
        }
    }
}