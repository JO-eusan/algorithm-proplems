import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int c = path[2];
            
            graph[u].add(new int[] {v, c});
            graph[v].add(new int[] {u, c});
        }
        
        // 출입구인지 여부
        boolean[] isGate = new boolean[n + 1];
        for (int gate : gates) {
            isGate[gate] = true;
        }

        // 산봉우리인지 여부
        boolean[] isSummit = new boolean[n + 1];
        for (int summit : summits) {
            isSummit[summit] = true;
        }
        
        // intensity[node] = 어떤 Gate에서 출발했을 때 node까지의 최소 intensity
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        // {현재 정점, 현재 intensity}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // -------------------------
        // Multi Source Dijkstra
        // 모든 Gate를 시작점으로 넣는다.
        // -------------------------
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.offer(new int[]{gate, 0});
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];

            // 이미 더 좋은 intensity로 방문한 적이 있으면 무시
            if (cost > intensity[node]) {
                continue;
            }

            // 산봉우리에 도착하면 더 진행하지 않는다.
            if (isSummit[node]) {
                continue;
            }

            // 인접 정점 탐색
            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int edgeCost = next[1];

                // Gate는 시작점만 가능
                if (isGate[nextNode]) {
                    continue;
                }

                // 새 intensity
                // 현재까지 최대 비용과
                // 이번 간선 비용 중 큰 값
                int nextIntensity = Math.max(cost, edgeCost);

                if (nextIntensity < intensity[nextNode]) {
                    intensity[nextNode] = nextIntensity;
                    pq.offer(new int[]{nextNode, nextIntensity});
                }
            }
        }

        // 번호가 작은 산봉우리를 우선하기 위해 정렬
        Arrays.sort(summits);

        int summit = 0;
        int minIntensity = Integer.MAX_VALUE;

        for (int s : summits) {
            if (intensity[s] < minIntensity) {
                minIntensity = intensity[s];
                summit = s;
            }
        }

        return new int[]{summit, minIntensity};
    }
}