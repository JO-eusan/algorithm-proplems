
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] adLists;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        adLists = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            adLists[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            adLists[num1].add(num2);
            adLists[num2].add(num1);
        }

        parent = new int[N+1];
        visited = new boolean[N+1];

        bfs();
        for(int i=2; i<=N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int root = q.poll();

            for(int c : adLists[root]) {
                if (!visited[c]) {
                    visited[c] = true;
                    parent[c] = root;
                    q.offer(c);
                }
            }
        }
    }
}