import java.util.Scanner;

public class Problem_2606 {

    /*깊이 우선 탐색(DFS, Depth-First Seacrh)
     * 트리나 그래프를 탐색하는 기법 중 하나,
     * 시작 노드에서 자식의 노드들을 순서대로 탐색하면서 깊이를 우선으로 탐색하는 알고리즘이다.
     * 깊이를 우선시하여 모든 경우의 수를 탐색하기 때문에 완전탐색 알고리즘에 속하지만
     * 항상 완전탐색으로 사용되지는 않는다. 주로 반복문을 활용하거나, 재귀문을 통하여 구현된다.
     *
     * DFS의 탐색과정
     * 특정 정점에서 시작하여 역추적(backtracking)하기 전에
     * 각 분기를 따라 가능한 한 멀리 탐색하는 것이다.
     * 탐색하는 과정은 다음과 같다
     * 1. 현재 노드를 방문한 것으로 표시한다
     * 2. 방문한 표시가 되어 있지 않은 각각의 인접한 정점을 탐색한다.
     * 3. 모두 방문하면, 방문하지 않은 정점이 없으면 역추적 한다.
     * 4. 모든 정점을 방문할 때까지 프로세스를 반복한다.
     *
     * DFS의 장점
     * 1. DFS는 현재 순회 중인 정점만 저장하는 스택 데이터 구조를 사용하기 때문에 BFS에 비해 메모리 공간을 덜 차지한다.
     * 2. DFS는 목표가 특정 정점(또는 모든 정점)에 최대한 빨리 도달하는 것일 때 유용하다.
     * 3. DFS를 사용하여 그래프에서 순환을 감지할 수 있다.
     *
     * DFS의 단점
     * 1. 순환 그래프의 경우 DFS가 무한 루프에 빠질 수 있다.
     * 2. DFS는 두 정점 사이의 최단 경로를 찾으려는 경우 사용하기에 가장 좋은 알고리즘이 아닐 수 있다.
     *
     * 반복구현(stack 활용) :
     * 반복구현에서는 스택 데이터 구조를 사용하여 방문할 정점을 추적한다.
     * 1. 알고리즘은 임의의
     * */

    static int n, m;
    static int[][] computer;
    static boolean[] visit;
    static int count;

    static void dfs(int x) {
        visit[x] = true; //

        for (int i = 1; i < n + 1; i++) {
            if (!visit[i] && computer[x][i] == 1) {
                dfs(i);
                count++;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 컴퓨터 개수 입력 받기
        m = sc.nextInt(); // 1번컴퓨터와 연결된 컴퓨터

        computer = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            computer[p1][p2] = computer[p2][p1] = 1; // 연결된 컴퓨터를 1로 초기화
        }

        dfs(1);
        System.out.println(count);

    }

}
