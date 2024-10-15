import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static boolean[][] graph;
  static boolean[] visited;
  static int answer;
  static int n, m;


  public static void dfs(int idx) {
    answer++;
    visited[idx] = true;
    for (int i = 1; i <= n; i++) {
      if (!visited[i] && graph[idx][i]) {
        dfs(i);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    graph = new boolean[n + 1][n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[x][y] = graph[y][x] = true;
    }

    dfs(1);
    System.out.println(answer-1);
  }
}

/*
답지 확인 :O
dfs에 대해서 잘 몰라서 답지를 처음부터 확인 하였다.
답지를 학인 했으나 이해가 되지 않아서 영상도  참고 하였다.
결과적으로 내가 가야하는 모든 길을 전부 탐색하고 그에 관한 출력을 주는 것인데,
여기서는 바이러스에 관련된 사항이니 자기 자신을 제외한 감염된 수를 출력해야하니 -1이였다.
결과적으로는 1->N개를 전부 탐색하여
 */