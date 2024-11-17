import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a); // 양방향 그래프
        }

        // 정점 번호가 작은 것부터 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 실행
        visited = new boolean[N + 1];
        dfs(start);

        // BFS 실행
        visited = new boolean[N + 1];
        bfs(start);

        // 결과 출력
        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());
    }

    static void dfs(int node) {
        visited[node] = true;
        dfsResult.append(node).append(" ");
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.append(node).append(" ");
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

