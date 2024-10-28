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

      list[a].add(new Node(b, w));  // Node 에 값을 넣어준다 [Node{b=1, w=1}], [Node{b=2, w=2}], [Node{b=2, w=2}, Node{b=3, w=3}],[Node{b=3, w=4}],[Node{b=3, w=4}, Node{b=4, w=5}]

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

    pq.add(new Node(k, 0)); //  우선숭위 queue에 노드값 삽입

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
ArrayList 와 LinkedList 의 시간 차이


 */