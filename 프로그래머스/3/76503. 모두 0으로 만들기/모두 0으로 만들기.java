import java.util.*;

class Solution {

    List<Integer>[] graph;

    public long solution(int[] a, int[][] edges) {

        long sum = 0;
        for (int x : a) sum += x;

        if (sum != 0) return -1;

        int n = a.length;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // int -> long 복사
        long[] weight = new long[n];
        for (int i = 0; i < n; i++) {
            weight[i] = a[i];
        }

        boolean[] visited = new boolean[n];

        // 부모 저장
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // DFS 방문 순서 저장
        List<Integer> order = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;

        // DFS
        while (!stack.isEmpty()) {
            int now = stack.pop();
            order.add(now);

            for (int next : graph[now]) {
                if (visited[next]) continue;

                visited[next] = true;
                parent[next] = now;
                stack.push(next);
            }
        }

        long answer = 0;

        // 자식 -> 부모 순서로 처리
        for (int i = order.size() - 1; i >= 1; i--) {

            int now = order.get(i);
            int p = parent[now];

            // 현재 노드를 0으로 만들기 위해 부모에게 넘김
            answer += Math.abs(weight[now]);
            weight[p] += weight[now];
        }

        return answer;
    }
}