import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1697 {
    public static void main(String[] args) throws IOException {

        /* 수빈이 위치 N이랑 동생 위치 K를 입력 받아서
         * 수빈이가 동생을 찾는 가장 빠른 시간을 출력하기 */

        /* 너비 우선 탐색(BFS, Breadth-First Search)
         *
         * 너비 우선 탐색이란? 루트 노드(혹은 다른 임의의 노드)에서 시작해서
         * 인접한 노드를 먼저 탐색하는 방법
         * 시작 정점으로부터 가까운 정점을 먼저 방문하고
         * 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법이다.
         *
         * 사용하는 경우? 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때
         * 이 방법을 선한택한다.
         * 예) 지구상에 존재하는 모든 친구 관계를 그래프로 표현한 후 Ash와 Vanessa 사이에 존재하는 경로를 찾는 경우
         * 깊이 우선 탐색의 경우 - 모든 친구 관계를 다 살펴봐야 할지도 모른다
         * 너비 우선 탐색의 경우 - Ash와 가까운 관계부터 남색
         *
         * 너비우선탐색(BFS)이 깊이우선탐색(DFS)보다 좀 더 복잡하다
         *
         * 너비우선탐색의 특징
         * - 직관적이지 않다
         *   : BFS는 시작 노드에서 시작해서 거리에 따라 단계별로 탐색한다고 볼 수 있다
         * - BFS는 재귀적으로 동작하지 않는다
         * - 이 알고리즘을 구현할 때 가장 큰 차이점은, 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를
         *   반드시 검사해야 한다는 것이다.
         *   : 이를 검사하지 않을 경우 무루프에 빠질 위험이 있다.
         * - BFS는 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 큐(Queue)를 사용한다.
         *   : 즉, 선입선출(FIFO) 원칙으로 탐색
         *   : 일반적으로 큐를 이용해서 반복적 형태로 구현하는 것이 가장 잘 도착한다.
         * 참고 : 'Prim', 'Dijkstra'알고리즘과 유사하다
         *
         * 너비우선탐색(BFS)의 과정
         * 깊이가 1인 모든 노드를 방문하고 나서 그 다음에는 깊이가 2인 모든 노드를,
         * 그 다음에는 깊이가 3인 모든 노드를 방문하는 식으로 계속 방문하다가
         * 더 이상 방문할 곳이 없으면 탐색을 마친다.
         *
         * 큐에 방문한 노드들을 삽입(enqueue)하고
         * 큐에서 꺼낸 노드와 인접한 노드들을 모두 차례로 방문하고,
         * 인접한 노드가 없다면 큐 앞에 노드를 꺼냄(dequeue)
         * 큐에 방문된 노드를 삽입(enqueue)
         * 큐가 소진될 때까지 계속한다
         * 설명 나와 있는 걸 대충 썼는데, 나중에 더 이해해볼 수 있도록 공부해야겠다
         *
         * 아무튼 너비우선탐색의 경우는 구현을 큐를 이용해서 한다는 걸 알고 있어야겠다.
         *
         *  너무 어려워
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //수빈이의 위치
        int K = Integer.parseInt(br.readLine()); //동생의 위치

        if (N == K) { //수빈이와 동생의 위치가 같다면
            System.out.println(0); //0초 걸린다고 출력하면 됨
            return;
        }

        boolean[] visited = new boolean[100001]; //음 이건 왜 100001인지 모르겠음
        // -> 0부터 100000까지의 위치를 나타내기 위함
        visited[N] = true; //방문한 위치 표시

        Queue<Integer> q = new LinkedList<>(); //BFS를 위해 사용할 큐를 생성함
        q.add(N); //큐에  위치 표시함
        int size = q.size(); //현재 큐의 크기를 size 변수에 저장
        int count = 0; //수빈이가 동생을 찾는데 걸린 시간(초)
        while (true) { //BFS의 반복을 위해 while문 시작
            count++; //매 반복마다 시간을 1초씩 증가시킴
            size = q.size(); //여기서 왜 다시 선언했는지는 잘 모르겠음
            // -> 현재 큐의 크기를 다시 확인하여 size 변수에 저장
            //    이번 루프에서 처리할 노드의 수를 나타냄
            for (int i = 0; i < size; i++) {
                //현재 큐의 크기만큼 반복 -> 각 위치를 처리하기 위한 루프임
                int x = q.remove();
                //큐에서 위치 x를 꺼냄
                visited[x] = true;
                //꺼낸 위치를 방문했다고 표시함
                if (x - 1 == K || x + 1 == K || x * 2 == K) {
                    //방문한 위치가 동생의 위치인 K와 일치하는지 확인
                    System.out.println(count); //일치할 경우 몇 번 걸렸는지 확인
                    return;
                }
                if (x - 1 >= 0 && !visited[x - 1]) {
                    //수빈이가 왼쪽으로 한 칸 이동할 수 있는지 확인
                    visited[x - 1] = true;
                    q.add(x - 1);
                    //왼쪽 위치가 유효하고 방문하지 않았다면 방문 표시 후 큐에 추가
                }
                if (x + 1 <= 100000 && !visited[x + 1]) {
                    //오른쪽으로 이동 가능한지 표시
                    visited[x + 1] = true;
                    q.add(x + 1);
                    //오른쪽 위치가 유효하고 방문하지 않았다면, 방문 표시 후 큐에 추가
                }

                if (x * 2 <= 100000 && !visited[x * 2]) {
                    visited[x * 2] = true;
                    q.add(x * 2);//한 번에 두 번 이동할 수 있는 경우의 수도 살펴봄
                }
            }
        }
    }
}
