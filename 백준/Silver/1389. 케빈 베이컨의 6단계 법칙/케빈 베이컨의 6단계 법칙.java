
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static int[] kevins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        kevins = new int[N+1];

        for(int i=1; i<=N; i++) {
            int kevin = bfs(i);
            kevins[i] = kevin;
        }
       
        int minPerson = 1;
        for(int i=2; i<=N; i++) {
            if (kevins[i] < kevins[minPerson]) {
                minPerson = i;
            }
        }

        System.out.println(minPerson);
    }

    public static int bfs(int start) {
        int[] steps = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

        steps[start] = 0;
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            List<Integer> nextNumbers = graph[now];
            for(int next : nextNumbers) {
                if (!visited[next]) {
                    steps[next] = steps[now] + 1;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        int sum = 0;
        for(int i=1; i<=N; i++) {
            sum += steps[i];
        }
        return sum;
    }
}