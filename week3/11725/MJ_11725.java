package week3;

/*
* 트리의 부모 찾기
* 첫째줄에 노드의 개수 N 입력
* 둘째줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점을 입력
* */


/*
흑흑
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //노드 개수 N입력

        List<List<Integer>> tree = new ArrayList<>();
        //정수형 요소를 담은 리스트를 다시 새로운 리스트에 넣어줌
        //tree라는 리스트 안에 여러 개의 List<Integer>가 들어가는 형태
        //이를 통해 트리구조를 나타낼 수 있음
        //각 리스트는 트리의 노드를 나타내거나, 자식 노드를 담을 수 있음

        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>()); //자식노드가 없는 정점 N+1개 생성
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] parent = new int[N + 1]; //각 노드의 부모를 저장
        boolean[] visited = new boolean[N + 1]; //노드 방문 여부를 체크
        Queue<Integer> queue = new LinkedList<>(); //큐를 사용해 bfs 수행
        queue.add(1); //루트 노드는 1이므로 먼저 저장해줌
        visited[1] = true; //루트 노드는 방문해준 것으로 체크함

        while (!queue.isEmpty()) {
            int node = queue.poll(); //큐에 담긴 노드를 선택
            //queue.poll() -> 큐의 첫번째 요소를 삭제(및 반환)함
            //                 만약 큐가 비어있으면 null을 반환
            //cf. queue.remove -> poll과 같이 큐의 첫번째 요소를 삭제(및 반환)하지만,
            //                     큐가 비어있으면 예외가 발생한다
            //    queue.clear -> 큐의 모든 요소를 삭제. 반환타입은 void(반환하지 않음)

            for (int neighbor : tree.get(node)) { //선택한 노드와 연결된 모든 노드를 탐색
                if (!visited[neighbor]) { //선택한 노드와 연결된 노드를 방문하지 않았을 경우
                    visited[neighbor] = true;
                    parent[neighbor] = node; //선택한 노드와 연결된 노드는 선택한 노드의 자식 노드임
                    queue.add(neighbor); //큐에 추가함
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) {
                sb.append(parent[i]).append('\n');
            }

            System.out.println(sb);
        }

    }
}
