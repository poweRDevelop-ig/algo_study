import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int v, e, k;
  static ArrayList<Node>[] list;
  static int[] dist;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    v=Integer.parseInt(st.nextToken());
    e=Integer.parseInt(st.nextToken());

    dist = new int[v + 1];
    list = new ArrayList[v + 1];
    visited = new boolean[v + 1];

    for (int i = 1; i <= v; i++) {
      list[i] = new ArrayList<>();
    }
    Arrays.fill(dist, Integer.MAX_VALUE); // Arrays.fill 은 배열의 모든 값을초기화 하는 것으로, dist 배열을 Integer.MAX_VALUE 값으로 초기화 시킨다.

    k = Integer.parseInt(br.readLine());    // 시작 번호
    dist[k] = 0;

    for (int i = 0; i < e; i++) {
      String[] tt = br.readLine().split(" ");

      int a = Integer.parseInt(tt[0]);   // 노드 1
      int b = Integer.parseInt(tt[1]);   // 노드 2
      int w = Integer.parseInt(tt[2]);   // 거리

      list[a].add(new Node(b, w));

    }
    solve();
    for (int i = 1; i <= v; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else {
        System.out.println(dist[i]);
      }
    }
  }

  public static void solve() {
    PriorityQueue<Node> pq = new PriorityQueue<>();

    pq.add(new Node(k, 0)); //  우선순위 queue에 노드값 삽입

    while (!pq.isEmpty()) { //
      Node a = pq.poll();

      if (visited[a.idx]) {
        continue;
      }
      visited[a.idx] = true;
      for (Node o : list[a.idx]) {
        if (dist[o.idx] > dist[a.idx] + o.w) {
          dist[o.idx] = dist[a.idx] + o.w;
          pq.add(new Node(o.idx, dist[o.idx]));
        }
      }
    }
  }
}

class Node implements Comparable<Node> {

  int idx, w;

  public Node(int idx, int w) {     // 노드에 저장
    this.idx = idx;
    this.w = w;
  }

  public int compareTo(Node o) {
    return this.w - o.w;
  }
}


/*
해설 확인 : O
1. 처음 입력한 수 만큼 list 배열을 초기화를 해준다.
2. dist 배열에 Arrays.fill 을 이용해 Integer 의 최댓값을 넣어준다.
3. 시작 번호를 지정해주고 dist 배열 k에 0을 입력해준다 ( 자기 자신을 찾는건 0이여야 해서 입력해준다.)
4.
이 문제에 대해 여러 문제들을 확인하다 ArrayList 가 아닌 LinkedList 로 문제를 풀었던 사람이 있었다.
이 사람의 문제 해결을 보고 아무 생각 없이 왜 ArrayList 가 사람들이 많이 썼는지에 대해서 궁금해서 찾아보았다.



이 코드는 다익스트라 알고리즘을 사용하여 시작 노드에서 각 노드까지의 최단 거리를 구하는 프로그램입니다. 코드의 주요 흐름과 각 단계는 아래와 같습니다:

1. 입력 및 초기화
v, e: 각각 노드의 개수와 간선의 개수를 나타냅니다.
dist: 최단 거리를 저장하는 배열로, 초기값을 Integer.MAX_VALUE로 설정하여 무한대로 초기화합니다. (자기 자신과의 거리는 0이므로 dist[k] = 0으로 설정)
list: 각 노드와 연결된 노드 정보를 저장하는 인접 리스트입니다. ArrayList 배열로 구성되어 있으며, 각 노드의 연결 정보를 담고 있습니다.
visited: 이미 처리한 노드를 표시하기 위한 boolean 배열입니다.
2. 간선 정보 입력
for문을 사용하여 각 간선 정보를 입력받습니다. 각 간선은 a, b, w로 구성되어 있으며, 이는 a에서 b로 가는 비용 w를 나타냅니다.
인접 리스트 list[a]에 Node 객체를 추가하여, 간선 정보를 저장합니다.
3. 다익스트라 알고리즘 (solve 메서드)
우선순위 큐(PriorityQueue)를 사용하여 비용이 가장 작은 노드부터 처리합니다.
시작 노드(k)를 큐에 추가하고, 우선순위 큐를 이용해 최단 거리가 가장 짧은 노드부터 탐색합니다.
탐색 중 해당 노드를 이미 방문한 경우 continue로 넘어가고, 그렇지 않다면 현재 노드에서 연결된 모든 노드에 대해 최단 거리 정보를 갱신합니다.
dist[o.idx] > dist[a.idx] + o.w 조건을 통해 기존 거리보다 더 짧은 거리가 발견되면 dist를 갱신하고, 해당 노드를 다시 큐에 추가합니다.

 */